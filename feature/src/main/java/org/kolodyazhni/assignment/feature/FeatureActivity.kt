package org.kolodyazhni.assignment.feature

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.kolodyazhni.assignment.feature.di.FeatureComponentProvider
import org.kolodyazhni.assignment.feature.di.FeatureViewModel
import org.kolodyazhni.assignment.feature.di.FeatureViewModelFactory
import org.kolodyazhni.assignment.feature.ui.FeatureVm
import javax.inject.Inject

class FeatureActivity : AppCompatActivity() {

    @Inject
    lateinit var vm: FeatureVm

    override fun onCreate(savedInstanceState: Bundle?) {
        ViewModelProvider(this, FeatureViewModelFactory(application as FeatureComponentProvider))
            .get(FeatureViewModel::class.java)
            .featureComponent
            ?.createDispatchAndroidInjectorActivity()
            ?.inject(this)
            ?: throw IllegalStateException()

        super.onCreate(savedInstanceState)

        setContentView(FrameLayout(this))
    }

    override fun onStart() {
        super.onStart()
        vm.call()
    }

}