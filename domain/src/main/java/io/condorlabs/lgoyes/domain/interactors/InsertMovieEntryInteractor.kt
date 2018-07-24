package io.condorlabs.lgoyes.domain.interactors

import io.condorlabs.lgoyes.domain.interactors.base.ObservableUseCase
import io.condorlabs.lgoyes.domain.models.MovieEntry
import io.condorlabs.lgoyes.domain.repositories.ILocalRepository
import io.reactivex.Observable
import io.reactivex.Scheduler

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
class InsertMovieEntryInteractor(mSubscribeOnScheduler: Scheduler,
                                 mObserveOnScheduler: Scheduler,
                                 private val mLocalRepository: ILocalRepository) :
        ObservableUseCase<Long, MovieEntry>(mSubscribeOnScheduler, mObserveOnScheduler) {
    override fun buildUseCase(params: MovieEntry): Observable<Long> =
            mLocalRepository.insertEntry(params)
}
