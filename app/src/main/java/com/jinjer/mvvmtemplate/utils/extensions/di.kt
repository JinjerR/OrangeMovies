package com.jinjer.mvvmtemplate.utils.extensions

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import org.kodein.di.*

inline fun <reified VM : ViewModel, T> T.fragmentViewModel(): Lazy<VM> where T : DIAware, T : Fragment {
    return viewModels (factoryProducer = { direct.instance() })
}

inline fun <reified VM : ViewModel, T> T.activityViewModel(): Lazy<VM> where T : DIAware, T : FragmentActivity {
    return viewModels(factoryProducer = { direct.instance() })
}

inline fun <reified VM : ViewModel> DI.Builder.bindViewModel(overrides: Boolean? = null): DI.Builder.TypeBinder<VM> {
    return bind<VM>(VM::class.java.simpleName, overrides)
}