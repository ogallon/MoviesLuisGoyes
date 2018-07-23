package io.condorlabs.lgoyes.data.models

import com.google.gson.annotations.SerializedName

data class APIMovie(
        @SerializedName("poster_path")
        val posterPath: String,
        val adult: Boolean,
        val overview: String,
        val release_date: String,
        @SerializedName("genre_ids")
        val genreIds: List<Int>,
        val id: Int,
        @SerializedName("original_title")
        val originalTitle: String,
        @SerializedName("original_language")
        val originalLanguage: String,
        val title: String,
        @SerializedName("backdrop_path")
        val backdropPath: String,
        val popularity: Double,
        @SerializedName("vote_count")
        val voteCount: Int,
        val video: Boolean,
        @SerializedName("vote_average")
        val voteAverage: Double
)
