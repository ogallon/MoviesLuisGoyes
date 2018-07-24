package io.condorlabs.lgoyes.domain.interactors

import io.condorlabs.lgoyes.domain.interactors.base.FlowableUseCase
import io.condorlabs.lgoyes.domain.models.detailutils.MovieEntry
import io.condorlabs.lgoyes.domain.repositories.ILocalRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
class GetAllMovieEntriesInteractor(mSubscribeOnScheduler: Scheduler,
                                   mObserveOnScheduler: Scheduler,
                                   private val mLocalRepository: ILocalRepository) :
        FlowableUseCase<List<MovieEntry>, Any?>(mSubscribeOnScheduler, mObserveOnScheduler) {
    override fun buildUseCase(params: Any?): Flowable<List<MovieEntry>> =
            mLocalRepository.getAllEntries()
}
