package com.jinjer.orangemovieapp.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkUtils {
    const val apiKey = "dad8a59d86a2793dda93aa485f7339c1"

    private const val baseUrl = "https://api.themoviedb.org/3/"
    const val moviePath = "movie"
    const val paramApiKey = "api_key"
    const val baseImageUrl = "https://image.tmdb.org/t/p/w500/"

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

    fun buildImageUrl(imagePath: String): String {
        return "$baseImageUrl$imagePath"
    }
}