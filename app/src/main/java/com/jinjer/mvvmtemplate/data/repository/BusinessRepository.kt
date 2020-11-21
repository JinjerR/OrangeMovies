package com.jinjer.mvvmtemplate.data.repository

import com.jinjer.mvvmtemplate.data.Result
import com.jinjer.mvvmtemplate.data.entity.BusinessEntity
import com.jinjer.mvvmtemplate.data.local.IBusinessLocalDataSource
import com.jinjer.mvvmtemplate.data.remote.IBusinessRemoteDataSource

class BusinessRepository(
    private val localDataSource: IBusinessLocalDataSource,
    private val remoteDataSource: IBusinessRemoteDataSource): IBusinessRepository {

    override suspend fun getBusinessById(businessId: String): Result<BusinessEntity> {
        return remoteDataSource.getBusinessById(businessId)
    }

    override suspend fun saveBusiness(businessEntity: BusinessEntity) {
        localDataSource.saveBusiness(businessEntity)
    }
}