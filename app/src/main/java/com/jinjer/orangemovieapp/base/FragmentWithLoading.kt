package com.jinjer.orangemovieapp.base

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.databinding.ViewDataBinding
import com.jinjer.orangemovieapp.ui.movie_content.common.LoadingFragment

abstract class FragmentWithLoading<T: ViewDataBinding>: BaseFragment<T>() {
    @IdRes abstract fun rootId(): Int
    @StringRes abstract fun titleRes(): Int

    private val title: String
    get() = getString(titleRes())

    private val tagLoading = "tag_loading_fragment"

    private val loadingFragment: LoadingFragment?
    get() = childFragmentManager.findFragmentByTag(tagLoading) as? LoadingFragment

    fun showLoading() {
        loadingFragment ?: run {
            childFragmentManager
                    .beginTransaction()
                    .add(rootId(), LoadingFragment.newInstance(title), tagLoading)
                    .commit()
        }
    }

    fun hideLoading() {
        childFragmentManager.findFragmentByTag(tagLoading)?.let { loadingFragment ->
            childFragmentManager
                    .beginTransaction()
                    .remove(loadingFragment)
                    .commit()
        }
    }
}