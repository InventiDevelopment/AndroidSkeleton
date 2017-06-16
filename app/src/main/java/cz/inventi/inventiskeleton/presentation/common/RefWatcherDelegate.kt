package cz.inventi.inventiskeleton.presentation.common

import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import cz.inventi.inventiskeleton.App

/**
 * Created by tomas.valenta on 6/15/2017.
 */
interface RefWatcherDelegate {
    var hasExited: Boolean

    fun isDestroyed(): Boolean

    fun onDestroy() {
        if (hasExited) {
            App.refWatcher.watch(this)
        }
    }
    fun onChangeEnded(changeHandler: ControllerChangeHandler, changeType: ControllerChangeType) {
        hasExited = !changeType.isEnter
        if (isDestroyed()) {
            App.refWatcher.watch(this)
        }
    }
}