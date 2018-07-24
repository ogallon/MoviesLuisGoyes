package io.condorlabs.lgoyes.domain.interactors

import io.condorlabs.lgoyes.domain.interactors.base.ObservableUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.condorlabs.lgoyes.domain.repositories.ILocalRepository
import io.reactivex.Observable
import io.reactivex.Scheduler

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
class UpdateMovieEntryInteractor(mSubscribeOnScheduler: Scheduler,
                                 mObserveOnScheduler: Scheduler,
                                 private val mLocalRepository: ILocalRepository) :
        ObservableUseCase<Int, Movie>(mSubscribeOnScheduler, mObserveOnScheduler) {
    override fun buildUseCase(params: Movie): Observable<Int> =
            mLocalRepository.updateEntry(params)
}
