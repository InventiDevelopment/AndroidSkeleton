package cz.inventi.inventiskeleton.domain.common

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by tomas.valenta on 6/21/2017.
 */

class BaseObservableUseCase<T, Params> @Inject constructor(override val threadExecutor: ThreadExecutor, override val postExecutionThread: PostExecutionThread): ObservableUseCase<T, Params> {


    private val disposables: CompositeDisposable = CompositeDisposable()

    /**
     * Builds an [Observable] which will be used when executing the current [BaseUseCase].
     */
    override fun buildUseCaseObservable(params: Params): Observable<T> = Observable.error { TODO("buildUseCaseObservable not implemented") }

    /**
     * Executes the current use case.

     * @param observer [DisposableObserver] which will be listening to the observable build
     * * by [.getData] ()} method.
     * *
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    override fun execute(observer: DisposableObserver<T>, params: Params) {
        val observable = this.buildUseCaseObservable(params)
                .subscribeOn(threadExecutor())
                .observeOn(postExecutionThread())
        addDisposable(observable.subscribeWith(observer))
    }

    override fun transform(params: Params): Observable<T> {
        return this.buildUseCaseObservable(params)
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    override fun dispose() {
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

