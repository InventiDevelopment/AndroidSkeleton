package cz.inventi.inventiskeleton.presentation.common

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.MviController
import com.hannesdorfmann.mosby3.mvi.MviPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import cz.inventi.inventiskeleton.di.conductorlib.ConductorInjection


abstract class MviBaseController<V : MvpView, P : MviPresenter<V, *>> : MviController<V, P>() {

    @LayoutRes abstract fun getLayoutResId(): Int

    protected open fun onViewBind(view: View) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        ConductorInjection.inject(this)

        val view = inflater.inflate(getLayoutResId(), container, false)
        ViewBinder.setup(this, view)

        onViewBind(view)

        return view
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)

        ViewBinder.tearDown(this)
    }
}
