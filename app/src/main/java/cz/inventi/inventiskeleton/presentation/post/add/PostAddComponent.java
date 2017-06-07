package cz.inventi.inventiskeleton.presentation.post.add;

import cz.inventi.inventiskeleton.di.ScreenModule;
import cz.inventi.inventiskeleton.di.ScreenScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@ScreenScope @Subcomponent(modules = { ScreenModule.class })
public interface PostAddComponent extends AndroidInjector<PostAddController> {

    @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<PostAddController> {
        public abstract Builder screenModule(ScreenModule screenModule);

        @Override public void seedInstance(PostAddController postAddController) {
            screenModule(new ScreenModule(postAddController.getClass().getSimpleName()));
        }
    }
}
