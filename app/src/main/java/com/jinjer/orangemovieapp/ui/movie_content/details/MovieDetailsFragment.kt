package com.jinjer.orangemovieapp.ui.movie_content.details

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.jinjer.orangemovieapp.R
import com.jinjer.orangemovieapp.base.BaseFragment
import com.jinjer.orangemovieapp.databinding.FragmentMovieDetailsBinding
import com.jinjer.orangemovieapp.ui.models.Movie.MovieItem
import com.jinjer.orangemovieapp.utils.extensions.fragmentViewModel

class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>() {
    private val detailsViewModel: MovieDetailsViewModel by fragmentViewModel()
    private var movieShortDetails: MovieItem? = null

    override fun layoutId(): Int = R.layout.fragment_movie_details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieShortDetails = arguments?.getParcelable(keyMovie)

        if (savedInstanceState == null) {
            movieShortDetails?.let { movie ->
                detailsViewModel.loadMovie(movie.id)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            movieShortDetails?.let { movieShort ->
                movieGenres.text = movieShort.genres
                movieTitle.text = movieShort.name
                movieRating.text = movieShort.rating
                movieRating.setTextColor(ContextCompat.getColor(requireContext(), movieShort.ratingColor))
                loadImage(movieShort.imgUrl, binding.backgroundImage)
            }

            detailsViewModel.movieDetails.observe(viewLifecycleOwner) { details ->
                loadImage(details.backgroundUrl, backgroundImage)
                description.text = details.description
            }
        }
    }

    private fun loadImage(imageUrl: String, img: ImageView) {
        Glide
            .with(img)
            .load(imageUrl)
            .centerCrop()
            .into(img)
    }

    companion object {
        private const val keyMovie = "key_movie_id"

        fun newInstance(movieShort: MovieItem) =
                MovieDetailsFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(keyMovie, movieShort)
                    }
                }
    }
}