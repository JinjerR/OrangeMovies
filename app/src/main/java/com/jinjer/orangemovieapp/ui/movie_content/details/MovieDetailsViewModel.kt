package com.jinjer.orangemovieapp.ui.movie_content.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinjer.orangemovieapp.data.Result.Success
import com.jinjer.orangemovieapp.data.repository.IMoviesRepository
import com.jinjer.orangemovieapp.ui.models.MovieDetails
import com.jinjer.orangemovieapp.ui.models.mappers.MovieMapper
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val movieRepository: IMoviesRepository,
    private val movieMapper: MovieMapper): ViewModel() {

    private val mMovieDetails = MutableLiveData<MovieDetails>()
    val movieDetails: LiveData<MovieDetails> = mMovieDetails

    fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            val apiResult = movieRepository.getMovieDetails(movieId)

            if (apiResult is Success) {
                mMovieDetails.value = movieMapper.toDetails(apiResult.data)
            } else {
                TODO("not implemented error handling in MovieDetailsViewModel")
            }
        }
    }
}