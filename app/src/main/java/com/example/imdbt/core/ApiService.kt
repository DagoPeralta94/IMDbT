package com.example.imdbt.core

import com.example.imdbt.data.model.MovieDb
import com.example.imdbt.data.model.MovieDbResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
        fun listTopRatedMovies(@Query("api_key") apiKey: String): Call<MovieDbResult>

}