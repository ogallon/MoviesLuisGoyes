package io.condorlabs.lgoyes.domain.models

import com.google.gson.annotations.SerializedName

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
class PopularMoviesResponse (
    val page : Int,
    @SerializedName("total_results")
    val totalResults : Int,
    @SerializedName("total_pages")
    val totalPages : Int,
    val results : List<Movie>
)
