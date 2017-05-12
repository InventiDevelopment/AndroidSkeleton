package cz.inventi.inventiskeleton.di;

import cz.inventi.inventiskeleton.domain.post.GetPostListUseCase;
import cz.inventi.inventiskeleton.presentation.post.list.PostListPresenter;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function0;

import javax.inject.Named;

/**
 * Created by cbahl on 12.03.17.
 */
@Module
public class ScreenModule {
    private String controllerName;

    public ScreenModule(String controllerName) {
        this.controllerName = controllerName;
    }

    @Provides @ScreenScope @Named("controllerName") String getControllerName() {
        return controllerName;
    }

    // TODO not sure if this should be here
    @Provides
    @ScreenScope
    static PostListPresenter providePostListPresenter(GetPostListUseCase getPostListUseCase){
        return new PostListPresenter(getPostListUseCase);
    }

    // TODO not sure if this should be here
    @Provides
    @ScreenScope
    static GetPostListUseCase provideGetPostListUseCase(){
        // TODO these two should be also injected
        return new GetPostListUseCase(() -> Schedulers.newThread(), () -> AndroidSchedulers.mainThread());
    }



}
