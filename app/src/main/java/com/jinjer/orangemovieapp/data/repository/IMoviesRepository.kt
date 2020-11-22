package com.jinjer.orangemovieapp.data.repository

import com.jinjer.orangemovieapp.data.Result
import com.jinjer.orangemovieapp.data.entity.MovieEntity
import com.jinjer.orangemovieapp.data.entity.MoviesEntity

interface IMoviesRepository {
    suspend fun getPopularMovies(pageNumber: Int): Result<MoviesEntity>

    suspend fun getTopRatedMovies(pageNumber: Int): Result<MoviesEntity>

    suspend fun getMovieDetails(movieId: Int): Result<MovieEntity>
}