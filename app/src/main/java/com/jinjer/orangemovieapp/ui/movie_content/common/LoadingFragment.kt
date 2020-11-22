package com.jinjer.orangemovieapp.ui.movie_content.common

import android.os.Bundle
import android.view.View
import com.jinjer.orangemovieapp.R
import com.jinjer.orangemovieapp.base.BaseFragment
import com.jinjer.orangemovieapp.databinding.FragmentLoadingBinding

class LoadingFragment: BaseFragment<FragmentLoadingBinding>() {
    companion object {
        const val keyTitle = "key_title"

        fun newInstance(title: String) = LoadingFragment().apply {
            arguments = Bundle().apply {
                putString(keyTitle, title)
            }
        }
    }

    override fun layoutId(): Int = R.layout.fragment_loading

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString(keyTitle)?.let {
            binding.progressTitle.text = it
        }
    }
}