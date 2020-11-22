package com.jinjer.orangemovieapp.ui.movie_content.common.recycler_view

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.jinjer.orangemovieapp.R
import com.jinjer.orangemovieapp.ui.models.Movie.MovieItem

class MovieViewHolder(view: View): BaseViewHolder(view) {
    private val movieImage: AppCompatImageView = view.findViewById(R.id.movie_img)
    private val movieName: AppCompatTextView = view.findViewById(R.id.movie_name)
    private val movieRating: AppCompatTextView = view.findViewById(R.id.movie_rating)
    private val movieGenres: AppCompatTextView = view.findViewById(R.id.movie_genres)

    fun bind(movie: MovieItem) {
        movieName.text = movie.name
        movieGenres.text = movie.genres
        movieRating.text = movie.rating
        movieRating.setTextColor(ContextCompat.getColor(itemView.context, movie.ratingColor))

        Glide
            .with(movieImage)
            .load(movie.imgUrl)
            .centerCrop()
            .into(movieImage)
    }

    override fun setClickListener(listener: (View) -> Unit) {
        itemView.setOnClickListener(listener)
    }
}