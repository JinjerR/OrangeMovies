package com.jinjer.orangemovieapp.ui.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class Movie {

    @Parcelize
    data class MovieItem(
            val id: Int,
            val name: String,
            val rating: String,
            val genres: String,
            val imgUrl: String,
            val ratingColor: Int): Movie(), Parcelable

    object LoadingItem: Movie()
}