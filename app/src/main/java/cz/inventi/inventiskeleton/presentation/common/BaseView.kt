package cz.inventi.inventiskeleton.presentation.common

import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * Created by tomas.valenta on 5/11/2017.
 */
interface BaseView : MvpView {
    fun showError(errorText: String)
}