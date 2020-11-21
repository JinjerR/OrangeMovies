package com.jinjer.mvvmtemplate.di

import com.jinjer.mvvmtemplate.ui.MainViewModel
import com.jinjer.mvvmtemplate.utils.extensions.bindViewModel
import org.kodein.di.DI.Module
import org.kodein.di.instance
import org.kodein.di.provider

val moduleViewModels = Module(DiConstants.moduleViewModels) {
    bindViewModel<MainViewModel>() with provider { MainViewModel(instance()) }
}