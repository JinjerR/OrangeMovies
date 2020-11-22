package com.jinjer.orangemovieapp.ui.main

import com.jinjer.orangemovieapp.ui.models.Movie.MovieItem

interface IMainController {
    fun showMovieDetails(movie: MovieItem)
}