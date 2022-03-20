package org.kolodyazhni.assignment.feature.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Subcomponent
import io.reactivex.disposables.CompositeDisposable
import org.kolodyazhni.assignment.core.di.InjectorsProviderComponent
import javax.inject.Qualifier
import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScope

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureDisposableQualifier

@FeatureScope
@Subcomponent(modules = [FeatureModule::class, FeatureUiModule::class])
interface FeatureComponent : InjectorsProviderComponent {

    @FeatureDisposableQualifier
    fun getCompositeDisposable(): CompositeDisposable
}

class FeatureViewModel(var featureComponent: FeatureComponent?) : ViewModel() {
    override fun onCleared() {
        featureComponent?.getCompositeDisposable()?.clear()
        featureComponent = null
    }
}

class FeatureViewModelFactory(private val componentProvider: FeatureComponentProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FeatureViewModel(componentProvider.createFeatureComponent()) as T
    }
}

interface FeatureComponentProvider {
    fun createFeatureComponent(): FeatureComponent
}