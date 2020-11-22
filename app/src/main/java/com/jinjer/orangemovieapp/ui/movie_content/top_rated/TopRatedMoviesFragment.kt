package com.jinjer.orangemovieapp.ui.movie_content.top_rated

import com.jinjer.orangemovieapp.R
import com.jinjer.orangemovieapp.ui.movie_content.common.MoviesFragment
import com.jinjer.orangemovieapp.ui.movie_content.common.RequestType

class TopRatedMoviesFragment : MoviesFragment() {
    companion object {
        const val position: Int = 1
        const val title: String = "Top Rated"
    }

    override fun titleRes(): Int = R.string.load_top_rated

    override val requestType: RequestType = RequestType.TOP_RATED
}