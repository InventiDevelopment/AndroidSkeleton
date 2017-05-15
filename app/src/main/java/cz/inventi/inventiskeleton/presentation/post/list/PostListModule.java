package cz.inventi.inventiskeleton.presentation.post.list;

import com.bluelinelabs.conductor.Controller;

import cz.inventi.inventiskeleton.di.ScreenScope;
import cz.inventi.inventiskeleton.di.conductorlib.ControllerKey;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@Module(subcomponents = { PostListComponent.class })
public abstract class PostListModule {
    @Binds @IntoMap @ControllerKey(PostListController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindHomeControllerInjectorFactory(PostListComponent.Builder builder);
}
