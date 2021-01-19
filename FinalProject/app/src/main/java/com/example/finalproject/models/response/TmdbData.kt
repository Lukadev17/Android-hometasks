package com.example.finalproject.models.response

data class PopularMovies(
    val results: List<Result>
)

data class UpcomingMovies(
        val results: List<Result>
)

data class TopRatedMovies(
        val results: List<Result>
)

data class Result(
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String
)