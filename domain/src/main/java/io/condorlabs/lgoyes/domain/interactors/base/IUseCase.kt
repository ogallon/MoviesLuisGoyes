/*
 * Copyright (c) Evercheck 2018.
 */

package io.condorlabs.lgoyes.domain.interactors.base

import io.reactivex.disposables.Disposable

/**
 *  @author Oscar Gallon on 6/22/18.
 */
interface IUseCase<R, P> {

    fun execute(params: P, onSuccessSubscriber: (response: R) -> Unit,
                onErrorSubscriber: (error: Throwable) -> Unit,
                doFinally: () -> Unit = {}): Disposable
}
