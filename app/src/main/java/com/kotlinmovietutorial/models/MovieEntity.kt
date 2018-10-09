package com.kotlinmovietutorial.models

import com.google.gson.annotations.SerializedName
import android.arch.persistence.room.PrimaryKey



data class MovieEntity (

    @PrimaryKey
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("adult")
    val adult: Boolean = false,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("original_title")
    val originalTitle: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("vote_count")
    val voteCount: Int = 0,

    @SerializedName("vote_average")
    val voteAverage: Double ,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("original_language")
    val originalLanguage: String?

)