package com.kotlinmovietutorial

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotlinmovietutorial.models.MovieEntity
import com.kotlinmovietutorial.models.MovieResponse
import com.kotlinmovietutorial.network.MovieApi
import com.kotlinmovietutorial.network.MovieApiService
import com.kotlinmovietutorial.repositories.MovieRepo
import com.kotlinmovietutorial.viewmodels.MovieViewModel
import com.kotlinmovietutorial.vo.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    internal lateinit var jsonApi:MovieApi;
    lateinit var movieViewModel:MovieViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        jsonApi = MovieApiService.instance.create(MovieApi::class.java)
//
//
//        jsonApi.getMoviews().enqueue(object : Callback<MovieResponse>{
//            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//                Log.d("","")
//            }
//
//            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
//                Log.d("","")
//            }
//        })


        movieViewModel= ViewModelProviders.of(this).get(MovieViewModel::class.java)

        val liveData:LiveData<Resource<MovieResponse>> = movieViewModel.getMovies()

        if(!liveData.hasObservers()){
            liveData.observe(this, Observer { resources ->

                resources?.data?.results?.forEach{
                    println("Movie ID[ ${it.id}] Name[${it.originalTitle}]")
                }

            })
        }


    }
}
