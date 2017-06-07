package cz.inventi.inventiskeleton.di;


import android.content.SharedPreferences;

import com.f2prateek.rx.preferences2.RxSharedPreferences;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import javax.inject.Named;

import cz.inventi.inventiskeleton.BuildConfig;
import cz.inventi.inventiskeleton.data.common.remote.RemotePlaceholderService;
import cz.inventi.inventiskeleton.data.post.LocalPostStore;
import cz.inventi.inventiskeleton.data.post.PostDataRepository;
import cz.inventi.inventiskeleton.domain.post.GetPostListUseCase;
import cz.inventi.inventiskeleton.domain.post.PostRepository;
import cz.inventi.inventiskeleton.presentation.post.add.PostAddPresenter;
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

    @Provides
    @ScreenScope
    static PostAddPresenter providePostAddPresenter(){
        return new PostAddPresenter();
    }

    // TODO not sure if this should be here
    @Provides
    @ScreenScope
    static GetPostListUseCase provideGetPostListUseCase(PostRepository postRepository){
        // TODO these two should be also injected
        return new GetPostListUseCase(postRepository, () -> Schedulers.newThread(), () -> AndroidSchedulers.mainThread());
    }


    @Provides
    @ScreenScope
    static PostRepository providePostRepository(RemotePlaceholderService remoteStore, LocalPostStore localStore){
        return new PostDataRepository(remoteStore, localStore);
    }

    @Provides
    @ScreenScope
    static LocalPostStore provideLocalPostStore(RxSharedPreferences rxPreferences, SharedPreferences sharedPreferences){
        return new LocalPostStore(rxPreferences, sharedPreferences, new Gson());
    }

    @Provides
    @ScreenScope
    static RxSharedPreferences provideRxSharedPreferences(SharedPreferences sharedPreferences){
        return RxSharedPreferences.create(sharedPreferences);
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
    static RemotePlaceholderService provideService(Retrofit retrofit){
        return retrofit.create(RemotePlaceholderService.class);
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
