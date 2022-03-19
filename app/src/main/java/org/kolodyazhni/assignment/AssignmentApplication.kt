package org.kolodyazhni.assignment

import android.app.Application
import org.kolodyazhni.assignment.di.AppComponent
import org.kolodyazhni.assignment.di.AppModule

class AssignmentApplication : Application(){

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule()).build()
    }

}
