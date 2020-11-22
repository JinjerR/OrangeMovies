package com.jinjer.orangemovieapp.data.remote.api

import com.jinjer.orangemovieapp.data.remote.NetworkUtils.moviePath
import com.jinjer.orangemovieapp.data.remote.models.MovieRemote
import com.jinjer.orangemovieapp.data.remote.models.MoviesRemote
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMovieApi {
    @GET("$moviePath/popular")
    suspend fun getPopularMovies( @Query("page") pageNumber: Int ): MoviesRemote

    @GET("$moviePath/top_rated")
    suspend fun getTopRatedMovies( @Query("page") pageNumber: Int ): MoviesRemote

    @GET("$moviePath/{movie_id}")
    suspend fun getMovieDetails( @Path("movie_id") movieId: Int ): MovieRemote
}