package cz.inventi.inventiskeleton.presentation.list

import com.hannesdorfmann.mosby3.mvp.MvpPresenter

/**
 * Created by semanticer on 05.05.2017.
 */

class ListPresenter : MvpPresenter<ListView> {

    override fun attachView(view: ListView) {
        view.showText("List controler text")
    }

    override fun detachView(retainInstance: Boolean) {

    }
}
