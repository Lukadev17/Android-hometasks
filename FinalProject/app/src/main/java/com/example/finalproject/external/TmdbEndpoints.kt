package com.example.finalproject.external


import com.example.finalproject.models.response.PopularMovies
import com.example.finalproject.models.response.TopRatedMovies
import com.example.finalproject.models.response.UpcomingMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbEndpoints {

    @GET("/3/movie/popular")
    fun getMovies(@Query("api_key") key: String): Call<PopularMovies>

    @GET("/3/movie/top_rated")
    fun getMoviesTopRated(@Query("api_key") key: String): Call<TopRatedMovies>

    @GET("/3/movie/upcoming")
    fun getMoviesUpcoming(@Query("api_key") key: String): Call<UpcomingMovies>

}