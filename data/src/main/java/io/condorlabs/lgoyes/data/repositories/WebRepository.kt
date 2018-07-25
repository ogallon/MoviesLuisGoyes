package io.condorlabs.lgoyes.data.repositories

import io.condorlabs.lgoyes.data.network.endpoints.MoviesService
import io.condorlabs.lgoyes.data.wrapper.APIPopularMoviesResponseListMoviesWrapper
import io.condorlabs.lgoyes.domain.models.Movie
import io.condorlabs.lgoyes.domain.repositories.IWebRepository
import io.reactivex.Observable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
class WebRepository(private val mMoviesService: MoviesService) : IWebRepository {
    override fun getListPopularMovies(apiKey: String, language: String, page: String): Observable<List<Movie>> =
            mMoviesService.obtainPopularMovies(apiKey, language, page).map {
                APIPopularMoviesResponseListMoviesWrapper.apply(it)
            }

    override fun getMovieBudget(movieId: String, apiKey: String, language: String): Observable<String> =
            mMoviesService.obtainMovieDetail(movieId, apiKey, language).map {
                it.budget.toString()
            }

    override fun getMovieTrailer(movieId: String, apiKey: String): Observable<String?> =
            mMoviesService.obtainMovieVideos(movieId, apiKey).map {
                it.results[0].key
            }
}
