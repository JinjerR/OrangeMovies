package com.jinjer.orangemovieapp.di

import com.jinjer.orangemovieapp.ui.models.mappers.MovieMapper
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.provider

val mappersModule = DI.Module(DiConstants.moduleMappers) {
    bind<MovieMapper>() with provider { MovieMapper() }
}