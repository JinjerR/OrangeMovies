package com.jinjer.orangemovieapp.ui.movie_content

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.jinjer.orangemovieapp.ui.movie_content.popular.PopularMoviesFragment
import com.jinjer.orangemovieapp.ui.movie_content.top_rated.TopRatedMoviesFragment

class MovieViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when(position) {
            PopularMoviesFragment.position -> PopularMoviesFragment()
            TopRatedMoviesFragment.position -> TopRatedMoviesFragment()

            else -> TODO()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            PopularMoviesFragment.position -> PopularMoviesFragment.title
            TopRatedMoviesFragment.position -> TopRatedMoviesFragment.title

            else -> TODO()
        }
    }
}