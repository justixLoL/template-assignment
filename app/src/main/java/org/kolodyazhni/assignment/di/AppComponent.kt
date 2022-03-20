package org.kolodyazhni.assignment.di

import dagger.Component
import org.kolodyazhni.assignment.feature.di.FeatureComponentProvider
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : FeatureComponentProvider