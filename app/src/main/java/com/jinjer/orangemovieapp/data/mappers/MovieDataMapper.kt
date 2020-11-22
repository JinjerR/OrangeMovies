package com.jinjer.orangemovieapp.data.mappers

import com.jinjer.orangemovieapp.data.entity.MovieEntity
import com.jinjer.orangemovieapp.data.remote.models.MovieRemote

class MovieDataMapper {
    fun toEntity(movieRemote: MovieRemote) = with(movieRemote) {
        MovieEntity(id, title, rating, description, genresIds, posterPath, backgroundPath)
    }
}