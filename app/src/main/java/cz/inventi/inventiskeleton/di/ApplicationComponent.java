package cz.inventi.inventiskeleton.di;

import cz.inventi.inventiskeleton.App;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@Component(
        modules = {
                ApplicationModule.class,
                AndroidBindingModule.class,
                AndroidSupportInjectionModule.class,
        }
)
@ApplicationScope
public interface ApplicationComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
