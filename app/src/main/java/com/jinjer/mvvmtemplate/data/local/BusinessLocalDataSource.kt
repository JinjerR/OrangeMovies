package com.jinjer.mvvmtemplate.data.local

import com.jinjer.mvvmtemplate.data.entity.BusinessEntity
import com.jinjer.mvvmtemplate.data.local.database.BusinessDataBase
import com.jinjer.mvvmtemplate.data.mappers.BusinessMapper

class BusinessLocalDataSource(
    businessDataBase: BusinessDataBase,
    private val businessMapper: BusinessMapper): IBusinessLocalDataSource {

    private val businessDao = businessDataBase.businessDao()

    override suspend fun getBusinessById(businessId: String): BusinessEntity? {
        return businessDao.getById(businessId)?.let {
            businessMapper.toEntity(it)
        }
    }

    override suspend fun saveBusiness(businessEntity: BusinessEntity) {
        businessDao.addBusiness(businessMapper.fromEntity(businessEntity))
    }
}