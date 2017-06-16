package cz.inventi.inventiskeleton.domain.common



import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.subscribers.ResourceSubscriber

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).

 * By convention each UseCase implementation will return the result using a [DisposableObserver]
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
abstract class UseCase<T, Params> internal constructor(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread) {
    private val disposables: CompositeDisposable

    init {
        this.disposables = CompositeDisposable()
    }

    /**
     * Builds an [Observable] which will be used when executing the current [UseCase].
     */
    internal abstract fun buildUseCaseObservable(params: Params): Flowable<T>

    /**
     * Executes the current use case.

     * @param observer [DisposableObserver] which will be listening to the observable build
     * * by [.getData] ()} method.
     * *
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: ResourceSubscriber<T>, params: Params) {
        val flowable: Flowable<T> = this.buildUseCaseObservable(params)
                .subscribeOn(threadExecutor())
                .observeOn(postExecutionThread())
        addDisposable(flowable.subscribeWith(observer))
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}
