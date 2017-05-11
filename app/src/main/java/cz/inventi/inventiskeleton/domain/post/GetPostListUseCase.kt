package cz.inventi.inventiskeleton.domain.post

import cz.inventi.inventiskeleton.data.model.Post
import cz.inventi.inventiskeleton.domain.common.PostExecutionThread
import cz.inventi.inventiskeleton.domain.common.ThreadExecutor
import cz.inventi.inventiskeleton.domain.common.UseCase
import io.reactivex.Observable

/**
 * Created by tomas.valenta on 5/11/2017.
 */
class GetPostListUseCase(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : UseCase<List<Post>, Unit>(threadExecutor, postExecutionThread) {
    override fun buildUseCaseObservable(params: Unit): Observable<List<Post>> {
        return Observable.just(
                listOf(
                        Post(1,1, "Title 1", "Body 1"),
                        Post(2, 2, "Title 2", "Body 2"),
                        Post(3, 3, "Title 3", "Body 3")
                ))
    }

}