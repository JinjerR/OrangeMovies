package com.jinjer.orangemovieapp.data.remote

import com.jinjer.orangemovieapp.data.remote.NetworkUtils.apiKey
import com.jinjer.orangemovieapp.data.remote.NetworkUtils.paramApiKey
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalUrl = original.url()

        val newUrl = originalUrl
            .newBuilder()
            .addQueryParameter(paramApiKey, apiKey)
            .build()

        val newRequest = original
            .newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}