package com.kotlinmovietutorial.network

import com.kotlinmovietutorial.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET


interface MovieApi {


    @GET("movie/popular")
    fun getMoviews():Call<MovieResponse>
}