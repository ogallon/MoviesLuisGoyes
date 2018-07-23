package io.condorlabs.lgoyes.data

import io.condorlabs.lgoyes.data.models.APIPopularMoviesResponse
import io.condorlabs.lgoyes.data.network.endpoints.MoviesService
import io.condorlabs.lgoyes.data.utils.BASE_URL
import io.condorlabs.lgoyes.domain.THE_MOVIE_DATABASE_API_KEY
import io.condorlabs.lgoyes.domain.WEB_REPOSITORY_DEFAULT_LANGUAGE
import io.reactivex.observers.TestObserver
import okhttp3.OkHttpClient
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {

    val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpClient())
            .build()

    val movieService = retrofit.create(MoviesService::class.java)
    @Test
    fun shouldGetMovies() {
        val testObserver = TestObserver<APIPopularMoviesResponse>()

        movieService.obtainPopularMovies(THE_MOVIE_DATABASE_API_KEY,
                WEB_REPOSITORY_DEFAULT_LANGUAGE, "1")
                .subscribeWith(testObserver)

        testObserver.assertNoErrors()
                .assertValueCount(1)
                .assertComplete()
    }
}
