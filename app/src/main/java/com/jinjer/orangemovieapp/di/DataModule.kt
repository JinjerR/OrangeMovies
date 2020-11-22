package com.jinjer.orangemovieapp.di

import com.jinjer.orangemovieapp.data.mappers.MovieDataMapper
import com.jinjer.orangemovieapp.data.remote.MovieRemoteDataSource
import com.jinjer.orangemovieapp.data.remote.IMovieRemoteDataSource
import com.jinjer.orangemovieapp.data.remote.NetworkUtils
import com.jinjer.orangemovieapp.data.remote.api.IMovieApi
import com.jinjer.orangemovieapp.data.repository.MoviesRepository
import com.jinjer.orangemovieapp.data.repository.IMoviesRepository
import com.jinjer.orangemovieapp.di.DiConstants.moduleData
import org.kodein.di.DI.Module
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import retrofit2.Retrofit

val dataModule = Module(moduleData) {
    bind<MovieDataMapper>() with provider { MovieDataMapper() }
    bind<Retrofit>() with singleton { NetworkUtils.buildRetrofit() }
    bind<IMovieApi>() with provider { NetworkUtils.provideApi(instance(), IMovieApi::class.java) }

    bind<IMovieRemoteDataSource>() with provider { MovieRemoteDataSource(instance(), instance()) }

    bind<IMoviesRepository>() with singleton { MoviesRepository(instance()) }
}