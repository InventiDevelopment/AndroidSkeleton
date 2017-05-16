package cz.inventi.inventiskeleton.di;


import com.facebook.stetho.okhttp3.StethoInterceptor;

import cz.inventi.inventiskeleton.BuildConfig;
import cz.inventi.inventiskeleton.data.remote.PlaceholderService;
import cz.inventi.inventiskeleton.domain.post.GetPostListUseCase;
import cz.inventi.inventiskeleton.presentation.post.list.PostListPresenter;
import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


import javax.inject.Named;


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
    static GetPostListUseCase provideGetPostListUseCase(PlaceholderService placeholderService){
        // TODO these two should be also injected
        return new GetPostListUseCase(placeholderService, () -> Schedulers.newThread(), () -> AndroidSchedulers.mainThread());
    }



    @Provides
    @ScreenScope
    static Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }


    @Provides
    @ScreenScope
    static PlaceholderService provideService(Retrofit retrofit){
        return retrofit.create(PlaceholderService.class);
    }

    @Provides
    @ScreenScope
    static OkHttpClient provideClient(HttpLoggingInterceptor loggingInterceptor){
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }


    @Provides
    @ScreenScope
    static HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BASIC : HttpLoggingInterceptor.Level.NONE);
        return interceptor;
    }


}
