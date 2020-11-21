package com.jinjer.mvvmtemplate.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkUtils {
    const val bearerToken = "v8GkzmSRFjW9Jvuw_B7mhyG69NPvJv--TFh2r_CHVr5iy4_Saon2v3gD6WvQww5Sl_HvekDvh8F7QZ5BnvdkKiyYhbYMCO5o9W3lJIXJs5pJpegV3HJohLN9y7ijX3Yx"

    private const val baseUrl = "https://api.yelp.com/v3/"

    const val businessesPath = "businesses"

    fun buildRetrofit(): Retrofit {
        val client = OkHttpClient
                .Builder()
                .addInterceptor(AuthorizationInterceptor())
                .build()

        return Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
    }

    fun <T>provideApi(retrofit: Retrofit, cls: Class<T>): T =
            retrofit.create(cls)
}