package io.condorlabs.lgoyes.data.repositories

import io.condorlabs.lgoyes.data.database.IMoviesDao
import io.condorlabs.lgoyes.data.mappers.DBMovieEntryMovieEntryMapper
import io.condorlabs.lgoyes.data.mappers.MovieEntryDBMovieEntryMapper
import io.condorlabs.lgoyes.domain.models.detailutils.MovieEntry
import io.condorlabs.lgoyes.domain.repositories.ILocalRepository
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
class LocalRepository(private val mMoviesDao : IMoviesDao) : ILocalRepository {
    override fun getAllEntries(): Flowable<List<MovieEntry>> {
        val rawList = mMoviesDao.getAllMovies()
        return rawList.map {
            it.map {
                DBMovieEntryMovieEntryMapper.apply(it)
            }
        }
    }

    override fun insertEntry(movie: MovieEntry): Completable {
        val entry = MovieEntryDBMovieEntryMapper.apply( movie )
        return Completable.create {
            mMoviesDao.insertMovie(entry)
            it.onComplete()
        }
    }

    override fun deleteEntry(movie: MovieEntry): Completable {
        val entry = MovieEntryDBMovieEntryMapper.apply( movie )
        return Completable.create {
            mMoviesDao.deleteMovie(entry)
            it.onComplete()
        }
    }

    override fun updateEntry(movie: MovieEntry): Completable {
        val entry = MovieEntryDBMovieEntryMapper.apply( movie )
        return Completable.create {
            mMoviesDao.updateMovie(entry)
            it.onComplete()
        }
    }
}
