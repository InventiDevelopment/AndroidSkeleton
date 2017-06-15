package cz.inventi.inventiskeleton.domain.post

import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.domain.common.PostExecutionThread
import cz.inventi.inventiskeleton.domain.common.ThreadExecutor
import cz.inventi.inventiskeleton.domain.common.UseCase
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by tomas.valenta on 6/15/2017.
 */

class AddPostUseCase @Inject constructor(val repository: PostRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : UseCase<AddPostUseCase.PostAddViewState, AddPostUseCase.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: AddPostUseCase.Params): Observable<PostAddViewState> {
        val error = PostAddViewState.ValidationError(isTitleValid(params), isBodyValid(params))

        if (error.bodyError || error.titleError) {
            return Observable.just(error)
        } else {
            return repository.savePost(params.title, params.body).map { PostAddViewState.Success(it) }
        }
    }

    private fun isTitleValid(params: Params) = params.title.length >= 3
    private fun isBodyValid(params: Params) = params.body.length >= 10

    data class Params(val title: String, val body: String)

    sealed class PostAddViewState {
        data class Success(val post: Post) : PostAddViewState()
        data class ValidationError(val titleError: Boolean, val bodyError: Boolean) : PostAddViewState()
        object Loading: PostAddViewState()
    }
}