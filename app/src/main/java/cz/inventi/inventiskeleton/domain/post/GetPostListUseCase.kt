package cz.inventi.inventiskeleton.domain.post

import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.domain.common.PostExecutionThread
import cz.inventi.inventiskeleton.domain.common.ThreadExecutor
import cz.inventi.inventiskeleton.domain.common.UseCase
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by tomas.valenta on 5/11/2017.
 */

class GetPostListUseCase @Inject constructor(val repository: PostRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : UseCase<List<Post>, GetPostListUseCase.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Flowable<List<Post>> {
        return repository.postList().map { it.take(params.limit) }
    }

    data class Params(val limit: Int = 100)
}