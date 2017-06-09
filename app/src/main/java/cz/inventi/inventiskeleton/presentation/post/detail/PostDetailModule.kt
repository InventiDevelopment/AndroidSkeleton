package cz.inventi.inventiskeleton.presentation.post.detail

import com.bluelinelabs.conductor.Controller

import cz.inventi.inventiskeleton.di.conductorlib.ControllerKey
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by ecnill on 6/7/2017.
 */

@Module(subcomponents = arrayOf(PostDetailComponent::class))
abstract class PostDetailModule {
    @Binds @IntoMap @ControllerKey(PostDetailController::class)
    internal abstract fun bindHomeControllerInjectorFactory(builder: PostDetailComponent.Builder): AndroidInjector.Factory<out Controller>
}