package cz.inventi.inventiskeleton.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController

import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by tomas.valenta on 5/11/2017.
 */

abstract class ButterKnifeController<V : MvpView, P : MvpPresenter<V>> : MvpController<V, P> {

    private var unbinder: Unbinder? = null

    protected constructor() {}
    protected constructor(args: Bundle) : super(args) {}

    protected abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup): View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflateView(inflater, container)
        unbinder = ButterKnife.bind(this, view)
        onViewBound(view)
        return view
    }

    protected fun onViewBound(view: View) {}

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        unbinder!!.unbind()
        unbinder = null
    }

}
