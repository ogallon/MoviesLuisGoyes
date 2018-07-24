package io.condorlabs.lgoyes.data.mappers

import io.condorlabs.lgoyes.data.models.DBMovieEntry
import io.condorlabs.lgoyes.domain.models.MovieEntry
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
object MovieEntryDBMovieEntryMapper : Function<MovieEntry, DBMovieEntry> {
    override fun apply(t: MovieEntry): DBMovieEntry {
        return DBMovieEntry( t.movieId, t.name, t.voteCount, t.posterPicturePath, t.voteAverage,
                t.overview, t.releaseDate, t.budget, t.trailerLink, t.isFavorite).apply { id = t.id }
    }
}
