package org.kolodyazhni.assignment.feature.di

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FeatureModule {

    @FeatureDisposableQualifier
    @Provides
    fun provideFeatureCompositeDisposable() = CompositeDisposable()
}