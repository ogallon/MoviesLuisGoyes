package io.condorlabs.lgoyes.domain.models

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
data class Movie (
        var movieId : String,
        var name : String,
        var voteCount : String,
        var posterPicturePath : String,
        var voteAverage : String,
        var overview : String,
        var releaseDate : String,
        var budget : String? = null,
        var trailerLink : String? = null,
        var isFavorite : Boolean? = null
)
