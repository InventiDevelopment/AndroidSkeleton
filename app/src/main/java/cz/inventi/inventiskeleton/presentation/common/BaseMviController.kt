package cz.inventi.inventiskeleton.presentation.common

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.hannesdorfmann.mosby3.MviController
import com.hannesdorfmann.mosby3.mvi.MviPresenter

/**
 * Created by tomas.valenta on 6/15/2017.
 */
abstract class BaseMviController <V : BaseView, P : MviPresenter<V, *>> : MviController<V, P>, BaseView, RefWatcherDelegate, ViewBindingDelegate {

    protected constructor() {}

    protected constructor(args: Bundle) : super(args) {}

    override var hasExited: Boolean = false

    override fun getParentActivity(): Activity? = activity

    override fun onDestroy() {
        super<RefWatcherDelegate>.onDestroy()
    }

    override fun onChangeEnded(changeHandler: ControllerChangeHandler, changeType: ControllerChangeType) {
        super<RefWatcherDelegate>.onChangeEnded(changeHandler, changeType)
    }

    override fun onDestroyView(view: View) {
        super<ViewBindingDelegate>.onDestroyView(view)
    }
}