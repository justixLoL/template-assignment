package org.kolodyazhni.assignment.core.di

import android.app.Activity
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector

interface InjectorsProviderComponent {
    fun createDispatchAndroidInjectorActivity() : DispatchingAndroidInjector<Activity>
    fun createDispatchAndroidInjectorFragment() : DispatchingAndroidInjector<Fragment>
}