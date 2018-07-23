package io.condorlabs.lgoyes.domain.repositories

import io.reactivex.Completable


/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
interface ILocalRepository {
    fun insertMovie( movie : DomainDBMovie ): Completable
}
