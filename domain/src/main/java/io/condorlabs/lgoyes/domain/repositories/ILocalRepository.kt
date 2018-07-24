package io.condorlabs.lgoyes.domain.repositories

import io.condorlabs.lgoyes.domain.models.MovieEntry
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
// https://medium.com/google-developers/room-rxjava-acb0cd4f3757
interface ILocalRepository {
    fun getAllEntries(): Flowable<List<MovieEntry>>

    fun insertEntry(movie: MovieEntry): Observable<Long>

    fun deleteEntry(movie: MovieEntry): Observable<Int>

    fun updateEntry(movie: MovieEntry): Observable<Int>
}
