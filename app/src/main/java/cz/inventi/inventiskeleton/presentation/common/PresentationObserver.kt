package cz.inventi.inventiskeleton.presentation.common

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.observers.DisposableObserver
import java.lang.ref.WeakReference

/**
 * Created by tomas.valenta on 5/11/2017.
 */

abstract class PresentationObserver<T, V: BaseView> constructor(view: V) : DisposableObserver<T>()  {

    private val viewRef: WeakReference<V> = WeakReference(view)

    override fun onError(e: Throwable?) {
        onView { it.showError(e!!.message!!) }
    }

    override fun onComplete() {
        // Blank
    }

    protected fun onView(func: (V) -> Unit) {
        viewRef.get()?.let { func(it) }
    }

}