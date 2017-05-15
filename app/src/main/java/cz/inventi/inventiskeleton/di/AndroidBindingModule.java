package cz.inventi.inventiskeleton.di;

import cz.inventi.inventiskeleton.presentation.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@Module
abstract class AndroidBindingModule {
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}
