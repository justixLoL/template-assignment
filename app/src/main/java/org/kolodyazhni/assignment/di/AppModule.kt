package org.kolodyazhni.assignment.di

import dagger.Module
import dagger.android.AndroidInjectionModule
import org.kolodyazhni.assignment.core.di.NetworkModule
import org.kolodyazhni.assignment.core.di.UtilsModule

@Module(includes = [AndroidInjectionModule::class, NetworkModule::class, UtilsModule::class])
class AppModule