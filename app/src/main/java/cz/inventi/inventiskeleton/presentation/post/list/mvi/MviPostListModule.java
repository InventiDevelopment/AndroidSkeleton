package cz.inventi.inventiskeleton.presentation.post.list.mvi;

import com.bluelinelabs.conductor.Controller;

import cz.inventi.inventiskeleton.di.conductorlib.ControllerKey;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@Module(subcomponents = { MviPostListComponent.class })
public abstract class MviPostListModule {
    @Binds @IntoMap @ControllerKey(MviPostListController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindHomeControllerInjectorFactory(MviPostListComponent.Builder builder);
}
