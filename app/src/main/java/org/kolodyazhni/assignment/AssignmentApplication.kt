package org.kolodyazhni.assignment

import android.app.Application
import org.kolodyazhni.assignment.di.AppComponent
import org.kolodyazhni.assignment.di.DaggerAppComponent
import org.kolodyazhni.assignment.feature.di.FeatureComponentProvider

class AssignmentApplication : Application(), FeatureComponentProvider{

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    override fun createFeatureComponent() = appComponent.createFeatureComponent()
}
