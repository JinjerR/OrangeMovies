package com.jinjer.orangemovieapp.data.entity

data class MoviesEntity(
        val movies: List<MovieEntity>?,
        val totalPages: Int?,
        val currentPage: Int?
)