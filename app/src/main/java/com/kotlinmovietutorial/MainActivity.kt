package com.kotlinmovietutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotlinmovietutorial.models.MovieResponse
import com.kotlinmovietutorial.network.MovieApi
import com.kotlinmovietutorial.network.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    internal lateinit var jsonApi:MovieApi;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        jsonApi = MovieApiService.instance.create(MovieApi::class.java)


        jsonApi.getMoviews().enqueue(object : Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("","")
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                Log.d("","")
            }
        })




    }
}
