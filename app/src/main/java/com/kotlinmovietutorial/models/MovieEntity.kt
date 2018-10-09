package com.kotlinmovietutorial.models

import com.google.gson.annotations.SerializedName
import android.arch.persistence.room.PrimaryKey



class MovieEntity {

    @PrimaryKey
    @SerializedName("id")
    val id: Int = 0

    @SerializedName("poster_path")
    val posterPath: String? = null

    @SerializedName("adult")
    val adult: Boolean = false

    @SerializedName("overview")
    val overview: String? = null

    @SerializedName("original_title")
    val originalTitle: String? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("vote_count")
    val voteCount: Int = 0

    @SerializedName("vote_average")
    val voteAverage: Double = 0.toDouble()

    @SerializedName("backdrop_path")
    val backdropPath: String? = null

    @SerializedName("original_language")
    val originalLanguage: String? = null

}