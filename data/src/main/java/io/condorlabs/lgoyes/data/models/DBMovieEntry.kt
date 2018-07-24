package io.condorlabs.lgoyes.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import io.condorlabs.lgoyes.data.utils.DATABASE_MOVIES_TABLE_NAME
import java.io.Serializable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
@Entity(
        tableName = DATABASE_MOVIES_TABLE_NAME
)
data class DBMovieEntry (
        @PrimaryKey
        val id: String,
        val movieId : String,
        val name : String,
        val voteCount : String,
        val posterPicturePath : String,
        val voteAverage : String,
        val overview : String,
        val releaseDate : String,
        val budget : String? = null,
        val trailerLink : String? = null,
        val isFavorite : Boolean = false
) : Serializable
