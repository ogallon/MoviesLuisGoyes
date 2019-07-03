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
data class DBMovieEntry(
        @PrimaryKey
        var movieId: String,
        var name: String,
        var voteCount: String,
        var posterPicturePath: String,
        var voteAverage: String,
        var overview: String,
        var releaseDate: String,
        var budget: String? = null,
        var trailerLink: String? = null,
        var isFavorite: Boolean = false
) : Serializable
