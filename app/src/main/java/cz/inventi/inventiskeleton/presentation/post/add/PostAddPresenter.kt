package cz.inventi.inventiskeleton.presentation.post.add

import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter
import cz.inventi.inventiskeleton.domain.post.AddPostUseCase
import cz.inventi.inventiskeleton.presentation.common.PresentationObserver
import javax.inject.Inject

/**
 * Created by tomas.valenta on 6/7/2017.
 */
class PostAddPresenter @Inject constructor(private val useCase: AddPostUseCase): MvpNullObjectBasePresenter<PostAddView>() {

    override fun attachView(view: PostAddView) {
        super.attachView(view)
        val titleEditEvents = view.titleEditEvents()
        val bodyEditEvents = view.bodyEditEvents()

        useCase.execute(PostAddObserver(view), AddPostUseCase.Params())

    }

    override fun detachView(retainInstance: Boolean) {
        useCase.dispose()
    }

    class PostAddObserver constructor(view: PostAddView): PresentationObserver<AddPostUseCase.PostAddViewState, PostAddView>(view) {
        override fun onNext(viewState: AddPostUseCase.PostAddViewState) = onView { it.renderState(viewState) }
    }

    fun onDoneClicked() {

    }
}