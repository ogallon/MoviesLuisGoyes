package io.condorlabs.lgoyes.data.mappers

import io.condorlabs.lgoyes.data.models.APIPopularMoviesResponse
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
object APIPopularMoviesResponsePopularMoviesResponseMapper :
        Function<APIPopularMoviesResponse, PopularMoviesResponse> {
    override fun apply(t: APIPopularMoviesResponse): PopularMoviesResponse {
        return PopularMoviesResponse(
                t.results
        )
    }
}
