package com.jinjer.mvvmtemplate.data.mappers

import com.jinjer.mvvmtemplate.data.entity.BusinessEntity
import com.jinjer.mvvmtemplate.data.local.models.BusinessLocal
import com.jinjer.mvvmtemplate.data.remote.models.BusinessRemote

class BusinessMapper {
    fun toEntity(businessLocal: BusinessLocal) = with(businessLocal) {
        BusinessEntity(id, name)
    }

    fun fromEntity(businessEntity: BusinessEntity) = with(businessEntity) {
        BusinessLocal(id, name)
    }

    fun toEntity(businessRemote: BusinessRemote) = with(businessRemote) {
        BusinessEntity(id, name)
    }
}