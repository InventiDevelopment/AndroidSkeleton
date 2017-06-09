package cz.inventi.inventiskeleton.presentation.post.detail

import cz.inventi.inventiskeleton.di.ScreenModule
import cz.inventi.inventiskeleton.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by ecnill on 6/7/2017.
 */

@ScreenScope @Subcomponent(modules = arrayOf(ScreenModule::class))
interface PostDetailComponent : AndroidInjector<PostDetailController> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<PostDetailController>() {
        abstract fun screenModule(screenModule: ScreenModule): PostDetailComponent.Builder

        override fun seedInstance(postDetailController: PostDetailController) {
            screenModule(ScreenModule(postDetailController.javaClass.simpleName))
        }
    }
}

