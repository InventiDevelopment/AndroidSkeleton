package cz.inventi.inventiskeleton.presentation.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by tomas.valenta on 6/15/2017.
 */
interface ViewBindingDelegate {
    fun inflateView(inflater: LayoutInflater, container: ViewGroup): View

    fun onViewBind(view: View) {}

    fun onDestroyView(view: View) {
        ViewBinder.tearDown(this)
    }

    fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflateView(inflater, container)
        ViewBinder.setup(this, view)
        onViewBind(view)
        return view
    }
}