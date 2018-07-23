package io.condorlabs.lgoyes.data.di

import dagger.Module
import dagger.Provides
import io.condorlabs.lgoyes.data.network.endpoints.MoviesService
import io.condorlabs.lgoyes.data.repositories.WebRepository
import io.condorlabs.lgoyes.data.utils.MOVIES_SERVICE
import io.condorlabs.lgoyes.domain.repositories.IWebRepository
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
@Module(includes = [(ServiceProviderModule::class)])
class RepositoryModule {
    @Singleton
    @Provides
    fun provideWebRepository(@Named(MOVIES_SERVICE) mMoviesService: MoviesService):
            IWebRepository = WebRepository(mMoviesService)
}
