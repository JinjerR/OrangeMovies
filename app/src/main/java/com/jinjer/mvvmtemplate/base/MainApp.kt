package com.jinjer.mvvmtemplate.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.jinjer.mvvmtemplate.di.DiConstants.tagAppContext
import com.jinjer.mvvmtemplate.di.dataModule
import com.jinjer.mvvmtemplate.di.moduleViewModels
import com.jinjer.mvvmtemplate.utils.ViewModelFactory
import org.kodein.di.*

class MainApp: Application(), DIAware {
    override val di = DI.lazy {
        import(dataModule)
        import(moduleViewModels)

        bind<Context>(tagAppContext) with singleton { this@MainApp.applicationContext }
        bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(direct) }
    }
}