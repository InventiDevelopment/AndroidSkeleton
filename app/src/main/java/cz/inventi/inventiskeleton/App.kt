package cz.inventi.inventiskeleton


import com.bluelinelabs.conductor.Controller
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

import javax.inject.Inject

import cz.inventi.inventiskeleton.di.DaggerApplicationComponent
import cz.inventi.inventiskeleton.di.conductorlib.HasControllerInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by tomas.valenta on 5/11/2017.
 */

class App : DaggerApplication(), HasControllerInjector {

    @Inject
    lateinit var dispatchingControllerInjector: DispatchingAndroidInjector<Controller>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        refWatcher = LeakCanary.install(this)
    }

    override fun controllerInjector(): DispatchingAndroidInjector<Controller> {
        return dispatchingControllerInjector
    }

    companion object {
        lateinit var refWatcher: RefWatcher
    }
}
