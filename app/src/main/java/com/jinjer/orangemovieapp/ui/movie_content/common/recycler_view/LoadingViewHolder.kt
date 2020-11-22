package com.jinjer.orangemovieapp.ui.movie_content.common.recycler_view

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.jinjer.orangemovieapp.R

class LoadingViewHolder(view: View): BaseViewHolder(view) {
    private val btnLoadMore: AppCompatButton = view.findViewById(R.id.load_more)

    override fun setClickListener(listener: (View) -> Unit) {
        btnLoadMore.setOnClickListener(listener)
    }
}