package cz.inventi.inventiskeleton.presentation.post.add;

import com.bluelinelabs.conductor.Controller;

import cz.inventi.inventiskeleton.di.conductorlib.ControllerKey;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@Module(subcomponents = { PostAddComponent.class })
public abstract class PostAddModule {
    @Binds @IntoMap @ControllerKey(PostAddController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindHomeControllerInjectorFactory(PostAddComponent.Builder builder);
}
