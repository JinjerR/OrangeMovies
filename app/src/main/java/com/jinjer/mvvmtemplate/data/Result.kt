package com.jinjer.mvvmtemplate.data

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    object Error: Result<Nothing>()
}