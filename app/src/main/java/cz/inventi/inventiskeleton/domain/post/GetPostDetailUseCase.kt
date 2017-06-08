package cz.inventi.inventiskeleton.domain.post

import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.domain.common.PostExecutionThread
import cz.inventi.inventiskeleton.domain.common.ThreadExecutor
import cz.inventi.inventiskeleton.domain.common.UseCase
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ecnill on 6/8/2017.
 */

class GetPostDetailUseCase @Inject constructor(val repository: PostRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread)
    : UseCase<Post, GetPostDetailUseCase.Params>(threadExecutor, postExecutionThread) {

    data class Params(val postId: Int)

    override fun buildUseCaseObservable(params: Params): Observable<Post> {
        return repository.post(params.postId)
    }

}
