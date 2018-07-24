package io.condorlabs.lgoyes.domain.interactors.base

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/24/2018
 */
abstract class FlowableUseCase<R, P>(private val mSubscribeOnScheduler: Scheduler,
                            private val mObserverOnSchedulers: Scheduler) :
        IUseCase<R, P> {
    abstract fun buildUseCase(params: P): Flowable<R>

    override fun execute(params: P,
                         onSuccessSubscriber: (response: R) -> Unit,
                         onErrorSubscriber: (error: Throwable) -> Unit,
                         doFinally: () -> Unit): Disposable {
        return buildUseCase(params)
                .subscribeOn(mSubscribeOnScheduler)
                .observeOn(mObserverOnSchedulers)
                .doFinally(doFinally)
                .subscribe(onSuccessSubscriber, onErrorSubscriber)
    }
}
