package io.condorlabs.lgoyes.data.database

import android.arch.persistence.room.*
import io.condorlabs.lgoyes.data.models.DBMovieEntry
import io.reactivex.Flowable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
@Dao
interface IMoviesDao {
    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flowable<List<DBMovieEntry>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertMovie(movieEntry: DBMovieEntry)

    @Delete
    fun deleteMovie(movieEntry: DBMovieEntry)

    @Update
    fun updateMovie(movieEntry: DBMovieEntry)
}
