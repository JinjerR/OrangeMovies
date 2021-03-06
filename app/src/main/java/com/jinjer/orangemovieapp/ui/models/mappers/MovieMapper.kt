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
        val url = posterPath?.let { buildImageUrl(it) } ?: ""
        val ratingColor = rating?.let { buildRatingColor(it) } ?: -1

        MovieItem(
                id,
                name ?: "",
                buildRatingStr(rating ?: 0.0),
                buildGenresStr(genresIds ?: emptyList()),
                url,
                ratingColor
        )
    }

    fun toDetails(movieEntity: MovieEntity) = with(movieEntity) {
        val posterUrl = posterPath?.let { buildImageUrl(it) } ?: ""
        val backgroundUrl = backgroundPath?.let { buildImageUrl(it) } ?: ""

        MovieDetails(
            id,
            name ?: "",
            buildRatingStr(rating ?: 0.0),
            description ?: "",
            buildGenresStr(genresIds ?: emptyList()),
                posterUrl,
            backgroundUrl
        )
    }

    private fun buildGenresStr(genres: List<Int>): String {
        val strBuilder = StringBuilder("")

        genres.forEachIndexed { index, id ->
            strBuilder.append(Genres.list[id])

            if (index != genres.lastIndex) {
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
            in 0.0..5.9 -> R.color.bad_rating

            else -> -1
        }
    }
}