package io.condorlabs.lgoyes.domain.models

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
data class Movie (
        val databaseId: Int? = null,
        val movieId : String,
        val name : String,
        val voteCount : String,
        val posterPicturePath : String,
        val voteAverage : String,
        val overview : String,
        val releaseDate : String,
        val budget : String? = null,
        val trailerLink : String? = null,
        val isFavorite : Boolean? = null
)
