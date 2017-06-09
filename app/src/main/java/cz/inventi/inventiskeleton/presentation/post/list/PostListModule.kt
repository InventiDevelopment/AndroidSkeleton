package cz.inventi.inventiskeleton.presentation.post.list

import com.bluelinelabs.conductor.Controller

import cz.inventi.inventiskeleton.di.ScreenScope
import cz.inventi.inventiskeleton.di.conductorlib.ControllerKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@Module(subcomponents = arrayOf(PostListComponent::class))
abstract class PostListModule {
    @Binds @IntoMap @ControllerKey(PostListController::class)
    internal abstract fun bindHomeControllerInjectorFactory(builder: PostListComponent.Builder): AndroidInjector.Factory<out Controller>
}
