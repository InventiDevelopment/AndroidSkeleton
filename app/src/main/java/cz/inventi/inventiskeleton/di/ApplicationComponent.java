package cz.inventi.inventiskeleton.di;

import cz.inventi.inventiskeleton.App;
import cz.inventi.inventiskeleton.di.conductorlib.ConductorInjectionModule;
import cz.inventi.inventiskeleton.presentation.post.add.PostAddModule;
import cz.inventi.inventiskeleton.presentation.post.detail.PostDetailModule;
import cz.inventi.inventiskeleton.presentation.post.list.PostListModule;
import cz.inventi.inventiskeleton.presentation.post.list.mvi.MviPostListModule;
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
                ConductorInjectionModule.class,
                PostListModule.class,
                PostDetailModule.class,
                PostAddModule.class,
                MviPostListModule.class
        }
)
@ApplicationScope
public interface ApplicationComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }

}
