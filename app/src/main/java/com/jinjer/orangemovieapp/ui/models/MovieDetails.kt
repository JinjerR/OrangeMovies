package com.jinjer.orangemovieapp.ui.models

data class MovieDetails(
    val id: Int,
    val name: String,
    val rating: String,
    val description: String,
    val genres: String,
    val posterUrl: String,
    val backgroundUrl: String)