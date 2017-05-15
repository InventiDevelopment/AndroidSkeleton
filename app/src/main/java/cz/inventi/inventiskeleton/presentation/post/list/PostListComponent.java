package cz.inventi.inventiskeleton.presentation.post.list;

import cz.inventi.inventiskeleton.di.ScreenModule;
import cz.inventi.inventiskeleton.di.ScreenScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@ScreenScope @Subcomponent(modules = { ScreenModule.class })
public interface PostListComponent extends AndroidInjector<PostListController> {

    @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<PostListController> {
        public abstract Builder screenModule(ScreenModule screenModule);

        @Override public void seedInstance(PostListController postListController) {
            screenModule(new ScreenModule(postListController.getClass().getSimpleName()));
        }
    }
}
