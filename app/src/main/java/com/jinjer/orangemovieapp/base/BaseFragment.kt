package com.jinjer.orangemovieapp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.jinjer.orangemovieapp.ui.main.IMainController
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.closestDI

abstract class BaseFragment<T: ViewDataBinding>: Fragment(), DIAware {
    protected lateinit var binding: T
    protected var mainController: IMainController? = null

    @LayoutRes abstract fun layoutId(): Int

    override val di: DI by closestDI()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainController = context as? IMainController
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        return binding.root
    }
}