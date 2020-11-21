package com.jinjer.mvvmtemplate.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
                .header("Authorization", "Bearer ${ NetworkUtils.bearerToken }")
                .build()

        return chain.proceed(newRequest)
    }
}