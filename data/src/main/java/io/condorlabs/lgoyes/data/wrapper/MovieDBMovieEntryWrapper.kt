package io.condorlabs.lgoyes.data.wrapper

import io.condorlabs.lgoyes.data.models.DBMovieEntry
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
object MovieDBMovieEntryWrapper : Function<Movie, DBMovieEntry> {
    override fun apply(t: Movie): DBMovieEntry {
        return DBMovieEntry(
                t.movieId,
                t.name,
                t.voteCount,
                t.posterPicturePath,
                t.voteAverage,
                t.overview,
                t.releaseDate,
                t.budget,
                t.trailerLink,
                t.isFavorite ?: false
        )
    }
}
