package org.kolodyazhni.assignment

import android.app.Application
import org.kolodyazhni.assignment.di.AppComponent
import org.kolodyazhni.assignment.di.DaggerAppComponent

class AssignmentApplication : Application(){

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

}
