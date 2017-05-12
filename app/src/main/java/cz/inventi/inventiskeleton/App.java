package cz.inventi.inventiskeleton;


import com.bluelinelabs.conductor.Controller;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;

import cz.inventi.inventiskeleton.di.DaggerApplicationComponent;
import cz.inventi.inventiskeleton.di.conductorlib.HasControllerInjector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

public class App extends DaggerApplication implements HasControllerInjector {

    @Inject
    protected DispatchingAndroidInjector<Controller> dispatchingControllerInjector;

    public static RefWatcher refWatcher;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().create(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }

    @Override
    public DispatchingAndroidInjector<Controller> controllerInjector() {
        return dispatchingControllerInjector;
    }
}
