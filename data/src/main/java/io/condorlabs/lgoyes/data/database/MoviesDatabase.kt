package io.condorlabs.lgoyes.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.condorlabs.lgoyes.data.models.DBMovieEntry
import io.condorlabs.lgoyes.data.utils.DATABASE_VERSION

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
@Database(entities = [DBMovieEntry::class], version = DATABASE_VERSION)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun getMoviesDao() : IMoviesDao
}
