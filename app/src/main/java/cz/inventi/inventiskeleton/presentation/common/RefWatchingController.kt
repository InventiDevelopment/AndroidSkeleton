package cz.inventi.inventiskeleton.presentation.common

import android.os.Bundle

import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

import cz.inventi.inventiskeleton.App

/**
 * Created by tomas.valenta on 5/11/2017.
 */

abstract class RefWatchingController<V : MvpView, P : MvpPresenter<V>> : ViewBindingController<V, P> {

    protected constructor() {}

    protected constructor(args: Bundle) : super(args) {}

    private var hasExited: Boolean = false

    public override fun onDestroy() {
        super.onDestroy()

        if (hasExited) {
            App.refWatcher.watch(this)
        }
    }

    override fun onChangeEnded(changeHandler: ControllerChangeHandler, changeType: ControllerChangeType) {
        super.onChangeEnded(changeHandler, changeType)

        hasExited = !changeType.isEnter
        if (isDestroyed) {
            App.refWatcher.watch(this)
        }
    }
}