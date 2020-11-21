package com.jinjer.mvvmtemplate.data.local

import com.jinjer.mvvmtemplate.data.entity.BusinessEntity

interface IBusinessLocalDataSource {
    suspend fun getBusinessById(businessId: String): BusinessEntity?

    suspend fun saveBusiness(businessEntity: BusinessEntity)
}