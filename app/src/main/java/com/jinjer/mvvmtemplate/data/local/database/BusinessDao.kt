package com.jinjer.mvvmtemplate.data.local.database

import androidx.room.*
import com.jinjer.mvvmtemplate.data.local.models.BusinessLocal

@Dao
interface BusinessDao {
    @Query("SELECT * FROM businesses WHERE id = :businessId")
    suspend fun getById(businessId: String): BusinessLocal?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBusiness(business: BusinessLocal)
}