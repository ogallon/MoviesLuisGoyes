package io.condorlabs.lgoyes.data.wrapper

import io.condorlabs.lgoyes.data.models.APIPopularMoviesResponse
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
object APIPopularMoviesResponseListMoviesWrapper :
        Function<APIPopularMoviesResponse, List<Movie>> {
    override fun apply(t: APIPopularMoviesResponse): List<Movie> {
        return t.results.map {
            APIMovieMovieWrapper.apply(it)
        }
    }
}
