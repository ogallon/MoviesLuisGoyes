package io.condorlabs.lgoyes.domain.interactors

import io.condorlabs.lgoyes.domain.THE_MOVIE_DATABASE_API_KEY
import io.condorlabs.lgoyes.domain.interactors.base.ObservableUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.condorlabs.lgoyes.domain.repositories.ILocalRepository
import io.condorlabs.lgoyes.domain.repositories.IWebRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Scheduler

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/25/2018
 */
class GetFullMovieInteractor(mSubscribeOnScheduler: Scheduler,
                             mObserveOnScheduler: Scheduler,
                             private val mWebServiceRepository: IWebRepository,
                             private val mLocalRepository: ILocalRepository)
    : ObservableUseCase<Movie, String>(mSubscribeOnScheduler, mObserveOnScheduler) {
    override fun buildUseCase(params: String): Observable<Movie> = Observable.fromPublisher(mLocalRepository
            .getEntry(params.toInt()))
            .flatMap { extractedMovie ->
                mWebServiceRepository
                        .getMovieTrailer(extractedMovie, THE_MOVIE_DATABASE_API_KEY)
                        .flatMap { movieWithTrailer ->
                            mWebServiceRepository
                                    .getMovieBudget(movieWithTrailer, THE_MOVIE_DATABASE_API_KEY)
//                                    .doFinally { movieWithBudgetAndTrailer->
//
//                                            mLocalRepository.updateEntry( movieWithBudgetAndTrailer )
                        }
            }
}
