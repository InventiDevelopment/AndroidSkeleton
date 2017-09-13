package cz.inventi.inventiskeleton.presentation.post.detail

import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter
import cz.inventi.inventiskeleton.BuildConfig.API_PROFILE_PIC
import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.domain.post.GetPostDetailUseCase
import cz.inventi.inventiskeleton.presentation.common.PresentationObserver
import javax.inject.Inject

/**
 * Created by ecnill on 6/7/2017.
 */

class PostDetailPresenter @Inject constructor(val useCase: GetPostDetailUseCase) : MvpNullObjectBasePresenter<PostDetailView>() {

    var postId: Int = 0
    private lateinit var post: Post

    override fun attachView(view: PostDetailView) {
        super.attachView(view)
        if (postId != 0)  {
            useCase.execute(PostDetailObserver(view), GetPostDetailUseCase.Params(postId))
        }
    }

    override fun detachView(retainInstance: Boolean) {
        useCase.dispose()
    }

    fun onShowMoreCommentsClicked() {
//        view.showComments(post.comments) // TODO
        view.hideMoreCommentButton()
    }

    fun showUserProfilePicture(id: Int) {
        view.showProfilePicture(API_PROFILE_PIC + id.toString())
    }


   inner class PostDetailObserver constructor(view: PostDetailView) : PresentationObserver<Post, PostDetailView>(view) {
        override fun onNext(post: Post) {
            this@PostDetailPresenter.post = post
//            onView { it.showDetailPost(post.copy(comments = post.comments.take(3))) } //TODO
        }
    }

}