package com.jinjer.orangemovieapp

import com.jinjer.orangemovieapp.data.entity.MovieEntity
import com.jinjer.orangemovieapp.data.remote.NetworkUtils
import com.jinjer.orangemovieapp.ui.models.Movie.MovieItem
import com.jinjer.orangemovieapp.ui.models.MovieDetails
import com.jinjer.orangemovieapp.ui.models.mappers.MovieMapper
import org.junit.Test
import org.junit.Assert.*

class MovieMapperTest {

    private val movieMapper = MovieMapper()
    private val badMovieEntity = MovieEntity(1, null, null, null, null, null, null)
    private val fullMovieEntity = MovieEntity(
            1,
            "movie_name",
            5.7,
            "tra-la-la",
            listOf(28, 99),
            "poster_path.jpg",
            "background_path.jpg")

    @Test
    fun transformToShortDetails() {
        val expectedShortDetails = MovieItem(1, "", "0.0 / 10.0", "", "", -1)
        val badShortDetails = movieMapper.toShortDetails(badMovieEntity)

        assertEquals(expectedShortDetails, badShortDetails)

        val fullExpectedMovie = MovieItem(
                1,
                "movie_name",
                "5.7 / 10.0",
                "Action, Documentary",
                "${ NetworkUtils.baseImageUrl }poster_path.jpg",
                R.color.bad_rating
        )

        val fullShortMovie = movieMapper.toShortDetails(fullMovieEntity)
        assertEquals(fullExpectedMovie, fullShortMovie)
    }

    @Test
    fun transformToDetails() {
        val expectedDetails = MovieDetails(1, "", "0.0 / 10.0", "", "", "", "")
        val actualDetails = movieMapper.toDetails(badMovieEntity)

        assertEquals(expectedDetails, actualDetails)

        val fullExpectedDetails = MovieDetails(
                1,
                "movie_name",
                "5.7 / 10.0",
                "tra-la-la",
                "Action, Documentary",
                "${ NetworkUtils.baseImageUrl }poster_path.jpg",
                "${ NetworkUtils.baseImageUrl }background_path.jpg"
        )

        val actualFullDetails = movieMapper.toDetails(fullMovieEntity)
        assertEquals(fullExpectedDetails, actualFullDetails)
    }
}