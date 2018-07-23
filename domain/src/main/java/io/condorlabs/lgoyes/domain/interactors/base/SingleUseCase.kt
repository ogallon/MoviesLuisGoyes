/*
 * Copyright (c) Evercheck 2018.
 */

package io.condorlabs.lgoyes.domain.interactors.base

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.Disposable

/**
 *  @author Oscar Gallon on 6/22/18.
 */
abstract class SingleUseCase<R, P>(private val mSubscribeOnScheduler: Scheduler,
                                   private val mObserverOnSchedulers: Scheduler) : IUseCase<R, P> {

    abstract fun buildUseCase(params: P): Single<R>

    override fun execute(params: P,
                         onSuccessSubscriber: (response: R) -> Unit,
                         onErrorSubscriber: (error: Throwable) -> Unit,
                         doFinally: () -> Unit): Disposable {

        return buildUseCase(params).subscribeOn(mSubscribeOnScheduler)
                .observeOn(mObserverOnSchedulers)
                .doFinally(doFinally)
                .subscribe(onSuccessSubscriber, onErrorSubscriber)
    }
}
