package io.condorlabs.lgoyes.data.wrapper

import io.condorlabs.lgoyes.data.models.APIMovieDetail
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
object APIMovieDetailMovieWrapper : Function<APIMovieDetail, Movie> {
    override fun apply(t: APIMovieDetail): Movie {
        return Movie(
                t.id.toString(),
                t.title,
                t.voteCount.toString(),
                t.posterPath.toString(),
                t.voteAverage.toString(),
                t.overview,
                t.releaseDate,
                t.budget.toString(),
                null,
                null
        )
    }
}
