package io.condorlabs.lgoyes.data.models

import com.google.gson.annotations.SerializedName
import io.condorlabs.lgoyes.domain.models.Movie

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
class APIPopularMoviesResponse (
        val page : Int,
        @SerializedName("total_results")
        val totalResults : Int,
        @SerializedName("total_pages")
        val totalPages : Int,
        val results : List<Movie>
)
