package cz.inventi.inventiskeleton.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import cz.inventi.inventiskeleton.App;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@Module
abstract class ApplicationModule {
    @Binds
    abstract Application application(App app);

    @Provides
    static SharedPreferences preferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
