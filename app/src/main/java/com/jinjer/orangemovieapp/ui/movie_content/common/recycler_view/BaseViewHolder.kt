package com.jinjer.orangemovieapp.ui.movie_content.common.recycler_view

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(view: View): RecyclerView.ViewHolder(view) {
    abstract fun setClickListener(listener: (View) -> Unit)
}
