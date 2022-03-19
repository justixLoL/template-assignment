package org.kolodyazhni.assignment.di

import dagger.Module
import org.kolodyazhni.assignment.core.di.NetworkModule
import org.kolodyazhni.assignment.core.di.UtilsModule

@Module(includes = [NetworkModule::class, UtilsModule::class])
class AppModule