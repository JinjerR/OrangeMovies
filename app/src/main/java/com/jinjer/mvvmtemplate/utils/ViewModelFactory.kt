package com.jinjer.mvvmtemplate.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DirectDI
import org.kodein.di.instanceOrNull

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val injector: DirectDI) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return injector.instanceOrNull<ViewModel>(tag = modelClass.simpleName) as T?
                ?: modelClass.newInstance()
    }
}