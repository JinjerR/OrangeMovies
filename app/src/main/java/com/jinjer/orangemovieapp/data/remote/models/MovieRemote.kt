package com.jinjer.orangemovieapp.data.remote.models

import com.google.gson.annotations.SerializedName

data class MovieRemote(
    val id: Int,
    val title: String?,
    @SerializedName("vote_average")
    val rating: Double?,
    @SerializedName("overview")
    val description: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("backdrop_path")
    val backgroundPath: String?,
    @SerializedName("genre_ids")
    val genresIds: List<Int>?
)