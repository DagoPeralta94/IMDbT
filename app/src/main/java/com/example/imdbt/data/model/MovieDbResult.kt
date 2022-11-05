package com.example.imdbt.data.model

data class MovieDbResult(
    val page: Int = -1,
    val results: List<MovieDb> = emptyList(),
    val total_pages: Int = -1,
    val total_results: Int = -1
)
