package io.condorlabs.lgoyes.domain.interactors

import io.condorlabs.lgoyes.domain.interactors.base.FlowableUseCase
import io.condorlabs.lgoyes.domain.models.Movie
import io.condorlabs.lgoyes.domain.repositories.ILocalRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
class GetAllMovieEntriesInteractor(mSubscribeOnScheduler: Scheduler,
                                   mObserveOnScheduler: Scheduler,
                                   private val mLocalRepository: ILocalRepository) :
        FlowableUseCase<List<Movie>, Any?>(mSubscribeOnScheduler, mObserveOnScheduler) {
    override fun buildUseCase(params: Any?): Flowable<List<Movie>> =
            mLocalRepository.getAllEntries()
}
