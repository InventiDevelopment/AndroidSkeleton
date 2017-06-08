package cz.inventi.inventiskeleton.presentation.post.detail

import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter
import cz.inventi.inventiskeleton.data.post.Post
import cz.inventi.inventiskeleton.domain.post.GetPostDetailUseCase
import cz.inventi.inventiskeleton.presentation.common.PresentationObserver
import javax.inject.Inject

/**
 * Created by ecnill on 6/7/2017.
 */

class PostDetailPresenter @Inject constructor(val useCase: GetPostDetailUseCase) : MvpNullObjectBasePresenter<PostDetailView>() {

    var postId: Int = 0

    override fun attachView(view: PostDetailView) {
        super.attachView(view)
        if (postId != 0)  {
            useCase.execute(PostDetailObserver(view), GetPostDetailUseCase.Params(postId))
        }
    }

    override fun detachView(retainInstance: Boolean) {
        useCase.dispose()
    }

    class PostDetailObserver constructor(view: PostDetailView) : PresentationObserver<Post, PostDetailView>(view) {
        override fun onNext(post: Post) {
            onView { it.showDetailPost(post) }
        }
    }

}