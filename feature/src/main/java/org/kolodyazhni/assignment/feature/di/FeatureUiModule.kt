package org.kolodyazhni.assignment.feature.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.kolodyazhni.assignment.feature.FeatureActivity

@Module
abstract class FeatureUiModule {

    @ContributesAndroidInjector
    abstract fun provideFeatureActivity() : FeatureActivity
}