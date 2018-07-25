package co.com.condorlabs.movies.di

import android.content.Context
import co.com.condorlabs.movies.utils.BASE_CONTEXT
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/19/2018
 */

@Module
class ApplicationModule(private val mApplicationContext : Context ){
    @Provides
    @Singleton
    fun provideContext():Context = mApplicationContext
}
