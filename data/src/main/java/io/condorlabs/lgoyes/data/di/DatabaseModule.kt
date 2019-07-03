package io.condorlabs.lgoyes.data.di

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import io.condorlabs.lgoyes.data.database.IMoviesDao
import io.condorlabs.lgoyes.data.database.MoviesDatabase
import io.condorlabs.lgoyes.data.utils.BASE_ROOM
import io.condorlabs.lgoyes.data.utils.DATABASE_NAME
import io.condorlabs.lgoyes.data.utils.MOVIES_DAO
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
@Module
class DatabaseModule {
    @Named(BASE_ROOM)
    @Provides
    @Singleton
    fun provideBaseRoom( context: Context ) : MoviesDatabase {
        val builder = Room.databaseBuilder( context, MoviesDatabase::class.java, DATABASE_NAME )
                .fallbackToDestructiveMigration()
        return builder.build()
    }

    @Named(MOVIES_DAO)
    @Provides
    @Singleton
    fun provideMoviesDao( @Named(BASE_ROOM) database: MoviesDatabase ) : IMoviesDao {
        return database.getMoviesDao()
    }
}
