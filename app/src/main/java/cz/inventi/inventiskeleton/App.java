package cz.inventi.inventiskeleton;


import cz.inventi.inventiskeleton.di.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().create(this);
    }
}
