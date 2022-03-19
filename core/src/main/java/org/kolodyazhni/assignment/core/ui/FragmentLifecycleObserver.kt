package org.kolodyazhni.assignment.core.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import io.reactivex.disposables.CompositeDisposable


/**
 * Manages disposables as scopes for Create/Destroy and Start/Stop lifecycle of fragment view.
 * Base logic to provide view binding of fragment
 */
abstract class FragmentLifecycleObserver<F : Fragment>(protected val fragment: F) {

    protected val onCreateDestroyDisposable = CompositeDisposable()
    protected val onStartStopDisposable = CompositeDisposable()

    init {
        fragment.viewLifecycleOwnerLiveData.observe(fragment) {
            subscribeToViewLifecycle()
        }
    }

    private fun subscribeToViewLifecycle() {
        fragment.viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {

            override fun onCreate(owner: LifecycleOwner) {
                onViewReady()
            }

            override fun onStart(owner: LifecycleOwner) {
                onStart()
            }

            override fun onStop(owner: LifecycleOwner) {
                onStop()
                onStartStopDisposable.clear()
            }

            override fun onDestroy(owner: LifecycleOwner) {
                onViewDestroy()
                onCreateDestroyDisposable.clear()
            }
        })
    }

    protected open fun onViewReady() {}

    protected open fun onStart() {}

    protected open fun onStop() {}

    protected open fun onViewDestroy() {}
}