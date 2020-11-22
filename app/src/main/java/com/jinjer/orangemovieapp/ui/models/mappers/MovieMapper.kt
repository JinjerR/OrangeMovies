package com.jinjer.orangemovieapp.ui.models.mappers

import com.jinjer.orangemovieapp.R
import com.jinjer.orangemovieapp.data.entity.MovieEntity
import com.jinjer.orangemovieapp.data.remote.NetworkUtils.buildImageUrl
import com.jinjer.orangemovieapp.ui.models.Movie.MovieItem
import com.jinjer.orangemovieapp.ui.models.MovieDetails
import com.jinjer.orangemovieapp.utils.Genres
import java.lang.StringBuilder

class MovieMapper {
    fun toShortDetails(movieEntity: MovieEntity): MovieItem = with(movieEntity) {
        MovieItem(
                id,
                name ?: "",
                buildRatingStr(rating ?: 0.0),
                buildGenresStr(genresIds ?: emptyList()),
                buildImageUrl(movieEntity.posterPath ?: ""),
                buildRatingColor(rating ?: 0.0)
        )
    }

    fun toDetails(movieEntity: MovieEntity) = with(movieEntity) {
        MovieDetails(
            id,
            name ?: "",
            buildRatingStr(rating ?: 0.0),
            description ?: "",
            buildGenresStr(genresIds ?: emptyList()),
            buildImageUrl(posterPath ?: ""),
            buildImageUrl(backgroundPath ?: "")
        )
    }

    private fun buildGenresStr(genres: List<Int>): String {
        val strBuilder = StringBuilder("")

        genres.forEach {
            strBuilder.append(Genres.list[it])

            if (it != genres.lastIndex) {
                strBuilder.append(", ")
            }
        }

        return strBuilder.toString()
    }

    private fun buildRatingStr(rating: Double): String {
        return "$rating / 10.0"
    }

    private fun buildRatingColor(rating: Double): Int {
        return when(rating) {
            in 8.0..10.0 -> R.color.good_rating
            in 6.0..7.9 -> R.color.normal_rating

            else -> R.color.bad_rating
        }
    }
}