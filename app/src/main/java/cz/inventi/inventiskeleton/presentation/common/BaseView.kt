package cz.inventi.inventiskeleton.presentation.common

import android.app.Activity
import android.support.design.widget.Snackbar
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * Created by tomas.valenta on 5/11/2017.
 */
interface BaseView : MvpView {

    fun getParentActivity(): Activity?

    fun showError(errorText: String) {
        val content: ViewGroup? = getParentActivity()?.findViewById(android.R.id.content)
        content?.getChildAt(0)?.let {
            Snackbar.make(it, errorText, Snackbar.LENGTH_LONG).show()
        }
    }
}