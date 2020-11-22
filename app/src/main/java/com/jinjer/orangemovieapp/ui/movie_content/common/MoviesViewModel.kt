package com.jinjer.orangemovieapp.ui.movie_content.common

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinjer.orangemovieapp.data.Result
import com.jinjer.orangemovieapp.data.repository.IMoviesRepository
import com.jinjer.orangemovieapp.ui.models.Movie
import com.jinjer.orangemovieapp.ui.models.Movie.LoadingItem
import com.jinjer.orangemovieapp.ui.models.mappers.MovieMapper
import com.jinjer.orangemovieapp.utils.OrangeConstants.tagApp
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val movieRepository: IMoviesRepository,
    private val movieMapper: MovieMapper): ViewModel() {

    private val mPopularMovies = MutableLiveData<List<Movie>>()
    val popularMovies: LiveData<List<Movie>> = mPopularMovies

    private val mInProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> = mInProgress

    private var nextPage = 1
    private var requestType: RequestType = RequestType.POPULAR

    fun initRequestType(type: RequestType) {
        requestType = type
    }

    fun loadNextPage() {
        viewModelScope.launch {
            mInProgress.value = true

            val result = if (requestType == RequestType.POPULAR) {
                movieRepository.getPopularMovies(nextPage)
            } else {
                movieRepository.getTopRatedMovies(nextPage)
            }

            mInProgress.value = false

            if (result is Result.Success) {
                val moviesData = result.data
                val movies = moviesData.movies ?: emptyList()

                val popularMovies: MutableList<Movie> = movies.map { movieMapper.toShortDetails(it) }.toMutableList()
                if (moviesData.totalPages ?: 1 > moviesData.currentPage ?: 1) {
                    popularMovies.add(LoadingItem)
                    nextPage++
                }

                val allMovies = (mPopularMovies.value ?: emptyList()).toMutableList().apply {
                    removeLastOrNull()
                    addAll(popularMovies)
                }

                mPopularMovies.value = allMovies

            } else {
                Log.e(tagApp, "Request Failed")
            }
        }
    }
}