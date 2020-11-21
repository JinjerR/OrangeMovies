package com.jinjer.mvvmtemplate.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jinjer.mvvmtemplate.data.local.models.BusinessLocal

@Database(entities = [BusinessLocal::class], version = 1)
abstract class BusinessDataBase: RoomDatabase() {
    abstract fun businessDao(): BusinessDao

    companion object {
        private const val dataBaseName = "database_businesses"

        fun buildDataBase(appContext: Context) = Room.databaseBuilder(
                appContext,
                BusinessDataBase::class.java,
                dataBaseName
        ).build()
    }
}