package io.condorlabs.lgoyes.domain.repositories

import io.condorlabs.lgoyes.domain.models.detailutils.MovieEntry
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
// https://medium.com/google-developers/room-rxjava-acb0cd4f3757
interface ILocalRepository {
    fun getAllEntries() : Flowable< List<MovieEntry> >

    fun insertEntry( movie : MovieEntry ) : Completable

    fun deleteEntry( movie : MovieEntry ) : Completable

    fun updateEntry( movie : MovieEntry ) : Completable
}
