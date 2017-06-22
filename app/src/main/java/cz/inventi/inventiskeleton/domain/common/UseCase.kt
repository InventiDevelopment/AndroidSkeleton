package cz.inventi.inventiskeleton.domain.common

import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver

/**
 * Created by tomas.valenta on 6/21/2017.
 */

interface UseCase<Observable, Subscriber, Params> {

    val threadExecutor: ThreadExecutor
    val postExecutionThread: PostExecutionThread

    fun execute(observer: Subscriber, params: Params)

    fun transform(params: Params): Observable {
        return buildUseCaseObservable(params)
    }

    fun dispose()

    fun buildUseCaseObservable(params: Params): Observable
}

interface ObservableUseCase<T, Params> : UseCase<Observable<T>, DisposableObserver<T>, Params >
