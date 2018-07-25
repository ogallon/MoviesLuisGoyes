package io.condorlabs.lgoyes.data.database

import android.arch.persistence.room.*
import io.condorlabs.lgoyes.data.models.DBMovieEntry
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
@Dao
interface IMoviesDao {
    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flowable<List<DBMovieEntry>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertMovie(movieEntry: DBMovieEntry) : Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movieEntries: List<DBMovieEntry>) : Array<Long>

    @Delete
    fun deleteMovie(movieEntry: DBMovieEntry) : Int

    @Update
    fun updateMovie(movieEntry: DBMovieEntry) : Int

    @Query("SELECT * FROM movies WHERE id = :id")
    fun getMovie(id : Int ): Flowable<DBMovieEntry>
}
