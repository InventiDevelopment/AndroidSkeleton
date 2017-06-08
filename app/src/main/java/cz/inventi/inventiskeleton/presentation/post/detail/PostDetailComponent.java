package cz.inventi.inventiskeleton.presentation.post.detail;

import cz.inventi.inventiskeleton.di.ScreenModule;
import cz.inventi.inventiskeleton.di.ScreenScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by ecnill on 6/7/2017.
 */

@ScreenScope
@Subcomponent(modules = { ScreenModule.class })
public interface PostDetailComponent extends AndroidInjector<PostDetailController> {

    @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<PostDetailController> {
        public abstract PostDetailComponent.Builder screenModule(ScreenModule screenModule);

        @Override public void seedInstance(PostDetailController postDetailController) {
            screenModule(new ScreenModule(postDetailController.getClass().getSimpleName()));
        }
    }
}

