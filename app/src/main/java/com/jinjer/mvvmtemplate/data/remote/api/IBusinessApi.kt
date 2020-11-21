package com.jinjer.mvvmtemplate.data.remote.api

import com.jinjer.mvvmtemplate.data.remote.NetworkUtils.businessesPath
import com.jinjer.mvvmtemplate.data.remote.models.BusinessRemote
import retrofit2.http.GET
import retrofit2.http.Path

interface IBusinessApi {
    @GET("$businessesPath/{business_id}")
    suspend fun getBusinessById( @Path("business_id") id: String ): BusinessRemote
}