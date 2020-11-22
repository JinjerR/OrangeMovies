package com.jinjer.orangemovieapp.ui.movie_content.popular

import com.jinjer.orangemovieapp.R
import com.jinjer.orangemovieapp.ui.movie_content.common.MoviesFragment
import com.jinjer.orangemovieapp.ui.movie_content.common.RequestType

class PopularMoviesFragment: MoviesFragment() {
    companion object {
        const val position: Int = 0
        const val title: String = "Popular"
    }

    override fun titleRes(): Int = R.string.load_popular

    override val requestType: RequestType = RequestType.POPULAR
}