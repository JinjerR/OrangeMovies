package com.jinjer.orangemovieapp.data.remote

import com.jinjer.orangemovieapp.data.Result
import com.jinjer.orangemovieapp.data.entity.MovieEntity
import com.jinjer.orangemovieapp.data.entity.MoviesEntity

interface IMovieRemoteDataSource {
    suspend fun getPopularMovies(pageNumber: Int): Result<MoviesEntity>

    suspend fun getTopRatedMovies(pageNumber: Int): Result<MoviesEntity>

    suspend fun getMovieDetails(movieId: Int): Result<MovieEntity>
}