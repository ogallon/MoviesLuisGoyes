package io.condorlabs.lgoyes.data.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import io.condorlabs.lgoyes.data.models.DBMovie

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
@Dao
interface DBManager {
    @Query("SELECT * FROM movies")
    fun queryMovies(): LiveData<List<DBMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: DBMovie)

    @Delete
    fun deleteMovie(movie: DBMovie)

    @Update
    fun updateMovie(movie: DBMovie)
}
