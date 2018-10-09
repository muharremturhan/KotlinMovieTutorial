package com.kotlinmovietutorial.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.kotlinmovietutorial.models.MovieResponse
import com.kotlinmovietutorial.network.MovieApi
import com.kotlinmovietutorial.network.MovieApiService
import com.kotlinmovietutorial.repositories.MovieRepo
import com.kotlinmovietutorial.vo.Resource

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val repo:MovieRepo

    init {
        repo = MovieRepo(MovieApiService.instance.create(MovieApi::class.java))
    }


    fun getMovies(): LiveData<Resource<MovieResponse>> {
        return repo.loadMovies()
    }
}