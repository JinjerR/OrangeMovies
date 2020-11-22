package com.jinjer.orangemovieapp.di

import com.jinjer.orangemovieapp.ui.movie_content.details.MovieDetailsViewModel
import com.jinjer.orangemovieapp.ui.movie_content.common.MoviesViewModel
import com.jinjer.orangemovieapp.utils.extensions.bindViewModel
import org.kodein.di.DI.Module
import org.kodein.di.instance
import org.kodein.di.provider

val moduleViewModels = Module(DiConstants.moduleViewModels) {
    bindViewModel<MoviesViewModel>() with provider { MoviesViewModel(instance(), instance()) }
    bindViewModel<MovieDetailsViewModel>() with provider { MovieDetailsViewModel(instance(), instance()) }
}