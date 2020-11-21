package com.jinjer.mvvmtemplate.data.repository

import com.jinjer.mvvmtemplate.data.Result
import com.jinjer.mvvmtemplate.data.entity.BusinessEntity

interface IBusinessRepository {
    suspend fun getBusinessById(businessId: String): Result<BusinessEntity>

    suspend fun saveBusiness(businessEntity: BusinessEntity)
}