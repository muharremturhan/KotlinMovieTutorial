package com.kotlinmovietutorial.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.kotlinmovietutorial.models.MovieResponse
import com.kotlinmovietutorial.network.MovieApi
import com.kotlinmovietutorial.vo.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieRepo(private val movieService: MovieApi) {

    fun loadMovies(): LiveData<Resource<MovieResponse>> {

        val data = MutableLiveData<Resource<MovieResponse>>()

        movieService.getMoviews().enqueue(object:Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                data.value= Resource.error(t.toString())
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                data.value= Resource.success(response?.body())
            }

        })

        return data;
    }



}