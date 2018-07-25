package io.condorlabs.lgoyes.domain.interactors

import io.condorlabs.lgoyes.domain.THE_MOVIE_DATABASE_API_KEY
import io.condorlabs.lgoyes.domain.interactors.base.ObservableUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.condorlabs.lgoyes.domain.repositories.ILocalRepository
import io.condorlabs.lgoyes.domain.repositories.IWebRepository
import io.reactivex.Observable
import io.reactivex.Scheduler

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/25/2018
 */
class GetMovieExtrasInteractor(mSubscribeOnScheduler: Scheduler,
                               mObserveOnScheduler: Scheduler,
                               private val mWebServiceRepository: IWebRepository,
                               private val mLocalRepository: ILocalRepository)
    : ObservableUseCase<Movie, Movie>(mSubscribeOnScheduler, mObserveOnScheduler) {
    override fun buildUseCase(params: Movie): Observable<Movie> = mWebServiceRepository
            .getMovieBudget(params, THE_MOVIE_DATABASE_API_KEY)
            .flatMap { movieWithBudget ->
                mWebServiceRepository
                        .getMovieTrailer(movieWithBudget, THE_MOVIE_DATABASE_API_KEY)
                        .doOnNext { movieWithBudgetAndTrailer->
                            mLocalRepository.updateEntry( movieWithBudgetAndTrailer )
                        }
            }
}
