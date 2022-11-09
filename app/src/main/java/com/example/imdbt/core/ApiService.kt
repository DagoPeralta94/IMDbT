package com.example.imdbt.core

import com.example.imdbt.data.model.MovieDb
import com.example.imdbt.data.model.MovieDbResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/top_rated")
        suspend fun listTopRatedMovies(@Query("api_key") apiKey: String): MovieDbResult

}