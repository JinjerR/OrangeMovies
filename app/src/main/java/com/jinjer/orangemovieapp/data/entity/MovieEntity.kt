package com.jinjer.orangemovieapp.data.entity

data class MovieEntity(
    val id: Int,
    val name: String?,
    val rating: Double?,
    val description: String?,
    val genresIds: List<Int>?,
    val posterPath: String?,
    val backgroundPath: String?)