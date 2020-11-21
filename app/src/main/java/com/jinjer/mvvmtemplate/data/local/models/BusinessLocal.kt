package com.jinjer.mvvmtemplate.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "businesses")
data class BusinessLocal(
    @PrimaryKey
    val id: String,
    val name: String?
)