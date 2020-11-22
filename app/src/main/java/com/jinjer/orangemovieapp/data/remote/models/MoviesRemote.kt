package com.jinjer.orangemovieapp.data.remote.models

import com.google.gson.annotations.SerializedName

data class MoviesRemote(
    @SerializedName("results")
    val movies: List<MovieRemote>,

    @SerializedName("page")
    val pageNumber: Int,

    @SerializedName("total_pages")
    val totalPageNumber: Int
)