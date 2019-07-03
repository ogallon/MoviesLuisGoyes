package io.condorlabs.lgoyes.data.models

import com.google.gson.annotations.SerializedName
import io.condorlabs.lgoyes.data.models.detailutils.APIGenre
import io.condorlabs.lgoyes.data.models.detailutils.APIProductionCompany
import io.condorlabs.lgoyes.data.models.detailutils.APIProductionCountry
import io.condorlabs.lgoyes.data.models.detailutils.APISpokenLanguage

data class APIMovieDetail(
        val adult: Boolean,
        @SerializedName("backdrop_path")
        val backdropPath: String,
        @SerializedName("belongs_to_collection")
        val belongsToCollection: Any,
        val budget: Int,
        val genres: List<APIGenre>,
        val homepage: String,
        val id: Int,
        @SerializedName("imdb_id")
        val imdbId: String,
        @SerializedName("original_language")
        val originalLanguage: String,
        @SerializedName("original_title")
        val originalTitle: String,
        val overview: String,
        val popularity: Double,
        @SerializedName("poster_path")
        val posterPath: Any,
        @SerializedName("production_companies")
        val productionCompanies: List<APIProductionCompany>,
        @SerializedName("production_countries")
        val productionCountries: List<APIProductionCountry>,
        @SerializedName("release_date")
        val releaseDate: String,
        val revenue: Int,
        val runtime: Int,
        @SerializedName("spoken_languages")
        val spokenLanguages: List<APISpokenLanguage>,
        val status: String,
        val tagline: String,
        val title: String,
        val video: Boolean,
        @SerializedName("vote_average")
        val voteAverage: Double,
        @SerializedName("vote_count")
        val voteCount: Int
)
