package com.jinjer.mvvmtemplate.data.remote

import com.jinjer.mvvmtemplate.data.Result
import com.jinjer.mvvmtemplate.data.entity.BusinessEntity
import com.jinjer.mvvmtemplate.data.mappers.BusinessMapper
import com.jinjer.mvvmtemplate.data.remote.api.IBusinessApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BusinessRemoteDataSource(
    private val businessApi: IBusinessApi,
    private val businessMapper: BusinessMapper
): IBusinessRemoteDataSource {

    override suspend fun getBusinessById(businessId: String): Result<BusinessEntity> {
        return withContext(Dispatchers.IO) {
            safeApiCall {
                businessMapper.toEntity(businessApi.getBusinessById(businessId))
            }
        }
    }

    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
        return try {
            Result.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            Result.Error
        }
    }
}