package cz.inventi.inventiskeleton.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController


abstract class ViewBindingController<V : MvpView, P : MvpPresenter<V>> : MvpController<V, P> {

    protected constructor() : super()
    protected constructor(args: Bundle?) : super(args)

    abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup): View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflateView(inflater, container)
        ViewBinder.setup(this, view)
        onViewBind(view)
        return view
    }

    protected open fun onViewBind(view: View) {}

    override fun onDestroyView(view: View) {
        ViewBinder.tearDown(this)
    }
}
