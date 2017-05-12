package cz.inventi.inventiskeleton.presentation.post.list

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import cz.inventi.inventiskeleton.data.model.Post
import cz.inventi.inventiskeleton.domain.post.GetPostListUseCase
import cz.inventi.inventiskeleton.presentation.common.PresentationObserver
import javax.inject.Inject

/**
 * Created by semanticer on 05.05.2017.
 */

class PostListPresenter @Inject constructor(val useCase: GetPostListUseCase) : MvpPresenter<PostListView> {

    override fun attachView(view: PostListView) {
        useCase.execute(PostListObserver(view), Unit)
    }

    override fun detachView(retainInstance: Boolean) {
        useCase.dispose()
    }

    class PostListObserver constructor(view: PostListView): PresentationObserver<List<Post>, PostListView>(view) {
        override fun onNext(list: List<Post>) {
            onView { it.showText(list[0].title) }
        }
    }
}
