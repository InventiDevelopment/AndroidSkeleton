package cz.inventi.inventiskeleton.presentation.post.add

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by tomas.valenta on 6/7/2017.
 */
class PostAddPresenter @Inject constructor(): MviBasePresenter<PostAddView, String>() {

    override fun bindIntents() {
        val state: Observable<String> = intent { view -> view.titleEditEvents() }
        subscribeViewState(state, { view, viewState -> view.render(viewState) })
    }


    fun onDoneClicked() {

    }
}