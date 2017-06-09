package cz.inventi.inventiskeleton.presentation.post.list

import cz.inventi.inventiskeleton.di.ScreenModule
import cz.inventi.inventiskeleton.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@ScreenScope @Subcomponent(modules = arrayOf(ScreenModule::class))
interface PostListComponent : AndroidInjector<PostListController> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<PostListController>() {
        abstract fun screenModule(screenModule: ScreenModule): Builder

        override fun seedInstance(postListController: PostListController) {
            screenModule(ScreenModule(postListController.javaClass.simpleName))
        }
    }
}
