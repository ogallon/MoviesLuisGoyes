package io.condorlabs.lgoyes.data

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import io.condorlabs.lgoyes.data.database.MoviesDatabase
import io.condorlabs.lgoyes.data.models.DBMovieEntry
import io.condorlabs.lgoyes.data.utils.DATABASE_NAME
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.subscribers.TestSubscriber

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.concurrent.TimeUnit

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class RoomInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()

        assertEquals("io.condorlabs.lgoyes.data.test", appContext.packageName)
    }

    @Test
    fun shouldInsert() {
        val appContext = InstrumentationRegistry.getTargetContext()

        val database = Room.databaseBuilder(appContext, MoviesDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        val moviesDao = database.getMoviesDao()

        val testObserver = TestObserver<Long>()
        val testMovieEntry = DBMovieEntry(
                "123",
                "name-test",
                "voteCount-test",
                "posterPicturePath-test",
                "voteAverage-test",
                "overview-test",
                "releaseDate-test",
                "budget-test",
                "trailerLink-test",
                false
        )
        Observable.just(moviesDao.insertMovie(testMovieEntry)).subscribeWith(testObserver)

        testObserver.assertNoErrors()
                .assertValueCount(1)
                .assertComplete()
    }

    @Test
    fun shouldGetEntries() {
        val appContext = InstrumentationRegistry.getTargetContext()

        val database = Room.databaseBuilder(appContext, MoviesDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        val moviesDao = database.getMoviesDao()

        val testSubscriber = TestSubscriber< List<DBMovieEntry> >()
        moviesDao.getAllMovies().subscribeWith( testSubscriber )
        testSubscriber
                //.awaitCount(1, BaseTestConsumer.TestWaitStrategy.SLEEP_1MS, 5000)
                .awaitDone(5000, TimeUnit.MILLISECONDS)
                .assertValueCount(1)
                .assertSubscribed()
                .assertNoErrors()
    }

    @Test
    fun shouldRemoveEntry() {
        val appContext = InstrumentationRegistry.getTargetContext()

        val database = Room.databaseBuilder(appContext, MoviesDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        val moviesDao = database.getMoviesDao()

        val testSubscriber = TestSubscriber< List<DBMovieEntry> >()
        moviesDao.getAllMovies().subscribeWith( testSubscriber )

        testSubscriber.awaitDone(5000, TimeUnit.MILLISECONDS)

        val rawMovieEntry = testSubscriber.values()[0][0]

        val testObserver = TestObserver<Int>()
        Observable.just(moviesDao.deleteMovie( rawMovieEntry )).subscribeWith(testObserver)
        testObserver.assertNoErrors()
                .assertValueCount(1)
                .assertComplete()
    }

    @Test
    fun shouldUpdateEntry() {
        val appContext = InstrumentationRegistry.getTargetContext()

        val database = Room.databaseBuilder(appContext, MoviesDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        val moviesDao = database.getMoviesDao()

        val testSubscriber = TestSubscriber< List<DBMovieEntry> >()
        moviesDao.getAllMovies().subscribeWith( testSubscriber )

        testSubscriber.awaitDone(5000, TimeUnit.MILLISECONDS)

        val rawMovieEntry = testSubscriber.values()[0][0]

        rawMovieEntry.name = "Otro"

        val testObserver = TestObserver<Int>()
        Observable.just(moviesDao.updateMovie( rawMovieEntry )).subscribeWith(testObserver)
        testObserver.assertNoErrors()
                .assertValueCount(1)
                .assertComplete()
    }


}
