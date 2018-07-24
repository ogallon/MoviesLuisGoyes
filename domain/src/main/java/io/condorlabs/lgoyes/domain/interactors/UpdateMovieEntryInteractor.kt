package io.condorlabs.lgoyes.domain.interactors

import io.condorlabs.lgoyes.domain.interactors.base.CompletableUseCase
import io.condorlabs.lgoyes.domain.models.detailutils.MovieEntry
import io.condorlabs.lgoyes.domain.repositories.ILocalRepository
import io.reactivex.Completable
import io.reactivex.Scheduler

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
class UpdateMovieEntryInteractor (mSubscribeOnScheduler: Scheduler,
                                  mObserveOnScheduler: Scheduler,
                                  private val mLocalRepository: ILocalRepository) :
        CompletableUseCase<MovieEntry>(mSubscribeOnScheduler, mObserveOnScheduler) {
    override fun buildUseCase(params: MovieEntry): Completable =
            mLocalRepository.updateEntry(params)
}
