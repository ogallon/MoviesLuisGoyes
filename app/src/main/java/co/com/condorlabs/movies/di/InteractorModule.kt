package co.com.condorlabs.movies.di

import co.com.condorlabs.movies.utils.OBTAIN_MOVIE_DETAIL_INTERACTOR
import co.com.condorlabs.movies.utils.OBTAIN_POPULAR_MOVIES_INTERACTOR
import dagger.Module
import dagger.Provides
import io.condorlabs.lgoyes.data.di.RepositoryModule
import io.condorlabs.lgoyes.domain.IO_THREAD_SCHEDULER
import io.condorlabs.lgoyes.domain.MAIN_THREAD_SCHEDULER
import io.condorlabs.lgoyes.domain.interactors.ObtainMovieDetailInteractor
import io.condorlabs.lgoyes.domain.interactors.ObtainPopularMoviesInteractor
import io.condorlabs.lgoyes.domain.interactors.base.IUseCase
import io.condorlabs.lgoyes.domain.models.MovieDetail
import io.condorlabs.lgoyes.domain.models.PopularMoviesResponse
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
    @Named(OBTAIN_MOVIE_DETAIL_INTERACTOR)
    fun providesObtainMovieDetailInteractor(
            @Named(IO_THREAD_SCHEDULER) subscribeOnScheduler: Scheduler,
            @Named(MAIN_THREAD_SCHEDULER) observeOnScheduler: Scheduler,
            webRepository: IWebRepository): IUseCase<MovieDetail, String> =
            ObtainMovieDetailInteractor(subscribeOnScheduler, observeOnScheduler, webRepository)

    @Singleton
    @Provides
    @Named(OBTAIN_POPULAR_MOVIES_INTERACTOR)
    fun providesObtainPopularMoviesInteractor(
            @Named(IO_THREAD_SCHEDULER) subscribeOnScheduler: Scheduler,
            @Named(MAIN_THREAD_SCHEDULER) observeOnScheduler: Scheduler,
            webRepository: IWebRepository): IUseCase<PopularMoviesResponse, Any?> =
            ObtainPopularMoviesInteractor(subscribeOnScheduler, observeOnScheduler, webRepository)
}
