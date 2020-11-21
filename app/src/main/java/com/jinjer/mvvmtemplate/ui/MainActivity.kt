package com.jinjer.mvvmtemplate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.jinjer.mvvmtemplate.R
import com.jinjer.mvvmtemplate.utils.extensions.activityViewModel
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI

class MainActivity : AppCompatActivity(), DIAware {
    override val di: DI by closestDI()

    private val mainViewModel: MainViewModel by activityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.test()
    }
}