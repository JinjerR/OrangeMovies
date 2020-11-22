package com.jinjer.orangemovieapp.ui.movie_content.common.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jinjer.orangemovieapp.R
import com.jinjer.orangemovieapp.ui.models.Movie
import com.jinjer.orangemovieapp.ui.models.Movie.LoadingItem
import com.jinjer.orangemovieapp.ui.models.Movie.MovieItem

class MovieAdapter(private val itemClick: (Movie) -> Unit): ListAdapter<Movie, BaseViewHolder>(diff) {

    private val movieItemType = 1
    private val loadingItemType = 2

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)

        return if (item is MovieItem) {
            movieItemType
        } else {
            loadingItemType
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val holder =  if (viewType == movieItemType) {
            val view = layoutInflater.inflate(R.layout.item_movie, parent, false)
            MovieViewHolder(view)
        } else {
            val view = layoutInflater.inflate(R.layout.item_loading, parent, false)
            LoadingViewHolder(view)
        }

        val clickListener: (view: View) -> Unit = {
            val position = holder.adapterPosition
            val data = getItem(position)
            itemClick(data)
        }

        holder.setClickListener(clickListener)

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is MovieViewHolder) {
            holder.bind(getItem(holder.adapterPosition) as MovieItem)
        }
    }

    companion object {
        private val diff = object: DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return when {
                    oldItem is MovieItem && newItem is MovieItem -> oldItem.id == newItem.id
                    oldItem is LoadingItem && newItem is LoadingItem -> true

                    else -> false
                }
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return when {
                    oldItem is MovieItem && newItem is MovieItem -> oldItem == newItem
                    oldItem is LoadingItem && newItem is LoadingItem -> true

                    else -> false
                }
            }
        }
    }
}