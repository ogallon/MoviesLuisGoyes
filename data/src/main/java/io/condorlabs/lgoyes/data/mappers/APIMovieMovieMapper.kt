package io.condorlabs.lgoyes.data.mappers

import io.condorlabs.lgoyes.data.models.APIMovie
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
object APIMovieMovieMapper : Function<APIMovie, Movie> {
    override fun apply(t: APIMovie): Movie {
        return Movie(t.posterPath, t.adult, t.overview, t.release_date, t.genreIds, t.id,
                t.originalTitle, t.originalLanguage, t.title, t.backdropPath, t.popularity,
                t.voteCount, t.video, t.voteAverage)
    }
}
