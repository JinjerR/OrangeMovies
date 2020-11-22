package com.jinjer.orangemovieapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jinjer.orangemovieapp.R
import com.jinjer.orangemovieapp.ui.models.Movie.MovieItem
import com.jinjer.orangemovieapp.ui.movie_content.details.MovieDetailsFragment

class MainActivity : AppCompatActivity(), IMainController {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showMovieDetails(movie: MovieItem) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_content, MovieDetailsFragment.newInstance(movie))
            .addToBackStack(null)
            .commit()
    }
}