package org.kolodyazhni.assignment.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.IllegalStateException

abstract class BaseViewBindingFragment<Binding : ViewBinding> : Fragment() {

    val viewBinding: Binding get() = binding ?: throw IllegalStateException("Binding can not be null")
    private var binding: Binding? = null

    abstract fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean,
        savedInstanceState: Bundle?
    ): Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        createViewBinding(inflater, container, false, savedInstanceState).also { binding = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}