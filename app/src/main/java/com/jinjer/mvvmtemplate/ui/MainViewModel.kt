package com.jinjer.mvvmtemplate.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinjer.mvvmtemplate.data.Result
import com.jinjer.mvvmtemplate.data.repository.IBusinessRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val businessRepo: IBusinessRepository
): ViewModel() {

    private val testBusinessId = "O0xFECgTDf1rbZzW9qUULQ"
    private val tagTest = "tag_test"

    fun test() {
        viewModelScope.launch {
            val remoteResult = businessRepo.getBusinessById(testBusinessId)
            if (remoteResult is Result.Success) {
                Log.i(tagTest, "remote success, business = ${ remoteResult.data }")
                businessRepo.saveBusiness(remoteResult.data)
            }
            else {
                Log.e(tagTest, " remote fail")
            }
        }
    }
}