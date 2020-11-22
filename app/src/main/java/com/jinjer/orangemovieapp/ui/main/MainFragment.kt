package com.jinjer.orangemovieapp.ui.main

import android.os.Bundle
import android.view.View
import com.jinjer.orangemovieapp.R
import com.jinjer.orangemovieapp.base.BaseFragment
import com.jinjer.orangemovieapp.databinding.FragmentMainBinding
import com.jinjer.orangemovieapp.ui.movie_content.MovieViewPagerAdapter

class MainFragment: BaseFragment<FragmentMainBinding>() {
    override fun layoutId(): Int = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            val movieAdapter = MovieViewPagerAdapter(childFragmentManager)
            movieViewPager.adapter = movieAdapter

            binding.tabs.setupWithViewPager(movieViewPager)
        }
    }
}