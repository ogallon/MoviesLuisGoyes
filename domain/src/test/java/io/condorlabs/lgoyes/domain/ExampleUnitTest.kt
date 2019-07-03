package io.condorlabs.lgoyes.domain

import org.junit.Test

import io.reactivex.Observable

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    fun testObservable() {
        
    }

    fun x(): Observable<String> {
        return Observable.create<String> {
            val texto = "asd"
            it.onNext(texto)
            it.onNext(texto)
            it.onNext(texto)
            it.onComplete()
            it.onNext(texto)
        }
    }
}
