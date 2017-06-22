package cz.inventi.inventiskeleton.domain.post

import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.domain.comment.CommentRepository
import cz.inventi.inventiskeleton.domain.common.BaseObservableUseCase
import cz.inventi.inventiskeleton.domain.common.ObservableUseCase
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

/**
 * Created by ecnill on 6/8/2017.
 */

class GetPostDetailUseCase
@Inject constructor(base: BaseObservableUseCase<Post, GetPostDetailUseCase.Params>, val postRepository: PostRepository, val repositoryComment: CommentRepository)
    : ObservableUseCase<Post, GetPostDetailUseCase.Params> by base {

    data class Params(val postId: Int)

    override fun buildUseCaseObservable(params: Params): Observable<Post> {
        val post = postRepository.post(params.postId)
        val comments = repositoryComment.commentList(params.postId)
        return Observable.combineLatest(post, comments, BiFunction { post, comments -> post.copy(comments = comments) })
    }

}
