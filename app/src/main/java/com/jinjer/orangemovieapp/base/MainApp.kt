package com.jinjer.orangemovieapp.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.jinjer.orangemovieapp.di.DiConstants.tagAppContext
import com.jinjer.orangemovieapp.di.dataModule
import com.jinjer.orangemovieapp.di.mappersModule
import com.jinjer.orangemovieapp.di.moduleViewModels
import com.jinjer.orangemovieapp.utils.ViewModelFactory
import org.kodein.di.*

class MainApp: Application(), DIAware {
    override val di = DI.lazy {
        import(dataModule)
        import(moduleViewModels)
        import(mappersModule)

        bind<Context>(tagAppContext) with singleton { this@MainApp.applicationContext }
        bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(direct) }
    }
}