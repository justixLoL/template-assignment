package org.kolodyazhni.assignment.core.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    fun provideGson() : Gson = Gson()
}