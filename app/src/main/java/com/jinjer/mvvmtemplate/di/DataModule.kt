package com.jinjer.mvvmtemplate.di

import com.jinjer.mvvmtemplate.data.local.BusinessLocalDataSource
import com.jinjer.mvvmtemplate.data.local.IBusinessLocalDataSource
import com.jinjer.mvvmtemplate.data.local.database.BusinessDataBase
import com.jinjer.mvvmtemplate.data.mappers.BusinessMapper
import com.jinjer.mvvmtemplate.data.remote.BusinessRemoteDataSource
import com.jinjer.mvvmtemplate.data.remote.IBusinessRemoteDataSource
import com.jinjer.mvvmtemplate.data.remote.NetworkUtils
import com.jinjer.mvvmtemplate.data.remote.api.IBusinessApi
import com.jinjer.mvvmtemplate.data.repository.BusinessRepository
import com.jinjer.mvvmtemplate.data.repository.IBusinessRepository
import com.jinjer.mvvmtemplate.di.DiConstants.moduleData
import com.jinjer.mvvmtemplate.di.DiConstants.tagAppContext
import org.kodein.di.DI.Module
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import retrofit2.Retrofit

val dataModule = Module(moduleData) {
    bind<BusinessDataBase>() with singleton { BusinessDataBase.buildDataBase(instance(tagAppContext)) }
    bind<BusinessMapper>() with provider { BusinessMapper() }
    bind<Retrofit>() with singleton { NetworkUtils.buildRetrofit() }
    bind<IBusinessApi>() with provider { NetworkUtils.provideApi(instance(), IBusinessApi::class.java) }

    bind<IBusinessLocalDataSource>() with provider { BusinessLocalDataSource(instance(), instance()) }
    bind<IBusinessRemoteDataSource>() with provider { BusinessRemoteDataSource(instance(), instance()) }

    bind<IBusinessRepository>() with singleton { BusinessRepository(instance(), instance()) }
}