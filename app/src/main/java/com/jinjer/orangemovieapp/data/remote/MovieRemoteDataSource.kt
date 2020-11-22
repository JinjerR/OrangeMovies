package com.jinjer.orangemovieapp.data.remote

import com.jinjer.orangemovieapp.data.Result
import com.jinjer.orangemovieapp.data.entity.MovieEntity
import com.jinjer.orangemovieapp.data.entity.MoviesEntity
import com.jinjer.orangemovieapp.data.mappers.MovieDataMapper
import com.jinjer.orangemovieapp.data.remote.api.IMovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRemoteDataSource(
    private val movieApi: IMovieApi,
    private val movieMapper: MovieDataMapper
): IMovieRemoteDataSource {

    override suspend fun getPopularMovies(pageNumber: Int): Result<MoviesEntity> {
        return withContext(Dispatchers.IO) {
            safeApiCall {
               val apiResult = movieApi.getPopularMovies(pageNumber)

               with(apiResult) {
                   MoviesEntity(
                           movies.map { movieMapper.toEntity(it) },
                           totalPageNumber,
                           pageNumber
                   )
               }
            }
        }
    }

    override suspend fun getTopRatedMovies(pageNumber: Int): Result<MoviesEntity> {
        return withContext(Dispatchers.IO) {
            safeApiCall {
                val apiResult = movieApi.getTopRatedMovies(pageNumber)

                with(apiResult) {
                    MoviesEntity(
                        movies.map { movieMapper.toEntity(it) },
                        totalPageNumber,
                        pageNumber
                    )
                }
            }
        }
    }

    override suspend fun getMovieDetails(movieId: Int): Result<MovieEntity> {
        return withContext(Dispatchers.IO) {
            safeApiCall {
                val apiResult = movieApi.getMovieDetails(movieId)
                movieMapper.toEntity(apiResult)
            }
        }
    }

    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
        return try {
            Result.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            Result.Error
        }
    }
}