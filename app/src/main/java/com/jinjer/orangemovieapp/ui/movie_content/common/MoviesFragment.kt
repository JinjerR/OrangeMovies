package com.jinjer.orangemovieapp.ui.movie_content.common

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jinjer.orangemovieapp.R
import com.jinjer.orangemovieapp.base.FragmentWithLoading
import com.jinjer.orangemovieapp.databinding.FragmentMoviesBinding
import com.jinjer.orangemovieapp.ui.models.Movie
import com.jinjer.orangemovieapp.ui.models.Movie.LoadingItem
import com.jinjer.orangemovieapp.ui.models.Movie.MovieItem
import com.jinjer.orangemovieapp.ui.movie_content.common.recycler_view.MovieAdapter
import com.jinjer.orangemovieapp.utils.extensions.fragmentViewModel
import com.jinjer.orangemovieapp.utils.recycler_view.RecyclerItemDecoration

abstract class MoviesFragment : FragmentWithLoading<FragmentMoviesBinding>() {
    private val popularViewModel: MoviesViewModel by fragmentViewModel()
    private val movieAdapter = MovieAdapter(::onMovieClicked)

    override fun layoutId(): Int = R.layout.fragment_movies

    override fun rootId(): Int = R.id.root_id

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(popularViewModel) {
            if (savedInstanceState == null) {
                initRequestType(requestType)
                loadNextPage()
            }

            popularMovies.observe(viewLifecycleOwner) { movies ->
                movieAdapter.submitList(movies)
            }
            inProgress.observe(viewLifecycleOwner) { progressRunning ->
                if (progressRunning) {
                    showLoading()
                } else {
                    hideLoading()
                }
            }
        }

        with(binding.movieList) {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(requireContext())

            val spaceVertical = resources.getDimension(R.dimen.space_half)
            val spaceHorizontal = resources.getDimension(R.dimen.space)

            addItemDecoration(RecyclerItemDecoration(spaceVertical.toInt(), spaceHorizontal.toInt()))
        }
    }

    private fun onMovieClicked(movie: Movie) {
        when(movie) {
            is LoadingItem -> {
                popularViewModel.loadNextPage()
            }
            is MovieItem -> {
                mainController?.showMovieDetails(movie)
            }
        }
    }

    abstract val requestType: RequestType
}