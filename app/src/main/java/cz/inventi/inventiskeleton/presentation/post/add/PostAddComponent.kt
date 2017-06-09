package cz.inventi.inventiskeleton.presentation.post.add

import cz.inventi.inventiskeleton.di.ScreenModule
import cz.inventi.inventiskeleton.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@ScreenScope @Subcomponent(modules = arrayOf(ScreenModule::class))
interface PostAddComponent : AndroidInjector<PostAddController> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<PostAddController>() {
        abstract fun screenModule(screenModule: ScreenModule): Builder

        override fun seedInstance(postAddController: PostAddController) {
            screenModule(ScreenModule(postAddController.javaClass.simpleName))
        }
    }
}
