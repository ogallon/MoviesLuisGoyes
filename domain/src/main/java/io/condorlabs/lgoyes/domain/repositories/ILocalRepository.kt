package io.condorlabs.lgoyes.domain.repositories

import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
// https://medium.com/google-developers/room-rxjava-acb0cd4f3757
interface ILocalRepository {
    fun getAllEntries(): Flowable<List<Movie>>

    fun getEntry( id : Int ) : Flowable< Movie >

    fun insertEntry(movie: Movie): Observable<Long>

    fun deleteEntry(movie: Movie): Observable<Int>

    fun updateEntry(movie: Movie): Observable<Int>
}
