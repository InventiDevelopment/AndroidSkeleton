package cz.inventi.inventiskeleton.presentation.list

import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * Created by semanticer on 05.05.2017.
 */

interface ListView : MvpView {
    fun showText(text: String)
}
