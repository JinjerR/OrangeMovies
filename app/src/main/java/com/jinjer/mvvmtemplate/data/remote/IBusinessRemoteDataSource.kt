package com.jinjer.mvvmtemplate.data.remote

import com.jinjer.mvvmtemplate.data.Result
import com.jinjer.mvvmtemplate.data.entity.BusinessEntity

interface IBusinessRemoteDataSource {
    suspend fun getBusinessById(businessId: String): Result<BusinessEntity>
}