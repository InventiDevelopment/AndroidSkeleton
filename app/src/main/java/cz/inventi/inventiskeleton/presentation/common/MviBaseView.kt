package cz.inventi.inventiskeleton.presentation.common

import com.hannesdorfmann.mosby3.mvp.MvpView


interface MviBaseView<ViewState> : MvpView {

    fun render(viewState: ViewState)
}
