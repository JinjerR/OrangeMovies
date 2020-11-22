package com.jinjer.orangemovieapp.utils.recycler_view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerItemDecoration(
    private val spaceVertical: Int = 0,
    private val spaceHorizontal: Int = 0) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val isGridLayout = parent.layoutManager is GridLayoutManager

        if (isGridLayout) {
            val columnCount = (parent.layoutManager as GridLayoutManager).spanCount
            val itemCount = parent.layoutManager!!.itemCount

            val isFirstRow = isFirstRow(position, columnCount)
            val isLastRow = isLastRow(position, columnCount, itemCount)

            with(outRect) {
                right = spaceHorizontal / 2
                left = spaceHorizontal / 2
                top = if (isFirstRow) 0 else spaceVertical / 2
                bottom = if (isLastRow) 0 else spaceVertical / 2
            }
        } else {
            val isFirstRow = position == 0
            val topMargin = if (isFirstRow) 0 else spaceVertical
            with(outRect) {
                top = topMargin
                left = spaceHorizontal / 2
                right = spaceHorizontal / 2
            }
        }
    }

    private fun isFirstRow(position: Int, columnCount: Int): Boolean {
        return position < columnCount
    }

    private fun isLastRow(position: Int, columnCount: Int, itemCount: Int): Boolean {
        return position >= (itemCount - columnCount)
    }
}