package cz.inventi.inventiskeleton.presentation.post.list.mvi;

import cz.inventi.inventiskeleton.di.ScreenModule;
import cz.inventi.inventiskeleton.di.ScreenScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@ScreenScope @Subcomponent(modules = { ScreenModule.class })
public interface MviPostListComponent extends AndroidInjector<MviPostListController> {

    @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<MviPostListController> {
        public abstract Builder screenModule(ScreenModule screenModule);

        @Override public void seedInstance(MviPostListController mviPostListController) {
            screenModule(new ScreenModule(mviPostListController.getClass().getSimpleName()));
        }
    }
}
