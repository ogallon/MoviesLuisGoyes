package co.com.condorlabs.movies.di

import co.com.condorlabs.movies.utils.GET_MOVIES_INTERACTOR
import dagger.Module
import dagger.Provides
import io.condorlabs.lgoyes.data.di.RepositoryModule
import io.condorlabs.lgoyes.domain.IO_THREAD_SCHEDULER
import io.condorlabs.lgoyes.domain.MAIN_THREAD_SCHEDULER
import io.condorlabs.lgoyes.domain.interactors.GetMoviesInteractor
import io.condorlabs.lgoyes.domain.interactors.base.IUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.condorlabs.lgoyes.domain.repositories.ILocalRepository
import io.condorlabs.lgoyes.domain.repositories.IWebRepository
import io.reactivex.Scheduler
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
@Module(includes = [RepositoryModule::class, SchedulerModule::class])
class InteractorModule {
    @Singleton
    @Provides
    @Named(GET_MOVIES_INTERACTOR)
    fun providesGetMoviesInteractor(
            @Named(IO_THREAD_SCHEDULER) subscribeOnScheduler: Scheduler,
            @Named(MAIN_THREAD_SCHEDULER) observeOnScheduler: Scheduler,
            webRepository: IWebRepository,
            localRepository: ILocalRepository): IUseCase<List<Movie>, Any?> =
            GetMoviesInteractor(
                    subscribeOnScheduler,
                    observeOnScheduler,
                    webRepository,
                    localRepository)
}
