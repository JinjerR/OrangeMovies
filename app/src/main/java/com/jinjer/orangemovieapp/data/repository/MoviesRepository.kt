package com.jinjer.orangemovieapp.data.repository

import com.jinjer.orangemovieapp.data.Result
import com.jinjer.orangemovieapp.data.entity.MovieEntity
import com.jinjer.orangemovieapp.data.entity.MoviesEntity
import com.jinjer.orangemovieapp.data.remote.IMovieRemoteDataSource

class MoviesRepository(
    private val remoteDataSource: IMovieRemoteDataSource): IMoviesRepository {

    override suspend fun getPopularMovies(pageNumber: Int): Result<MoviesEntity> {
        return remoteDataSource.getPopularMovies(pageNumber)
    }

    override suspend fun getTopRatedMovies(pageNumber: Int): Result<MoviesEntity> {
        return remoteDataSource.getTopRatedMovies(pageNumber)
    }

    override suspend fun getMovieDetails(movieId: Int): Result<MovieEntity> {
        return remoteDataSource.getMovieDetails(movieId)
    }
}