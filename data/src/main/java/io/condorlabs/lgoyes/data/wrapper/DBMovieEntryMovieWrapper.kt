package io.condorlabs.lgoyes.data.wrapper

import io.condorlabs.lgoyes.data.models.DBMovieEntry
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
object DBMovieEntryMovieWrapper : Function<DBMovieEntry, Movie> {
    override fun apply(t: DBMovieEntry): Movie {
        return Movie(
                t.id,
                t.movieId,
                t.name,
                t.voteCount,
                t.posterPicturePath,
                t.voteAverage,
                t.overview,
                t.releaseDate,
                t.budget,
                t.trailerLink,
                t.isFavorite
        )
    }
}
