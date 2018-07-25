package io.condorlabs.lgoyes.data.repositories

import io.condorlabs.lgoyes.data.network.endpoints.MoviesService
import io.condorlabs.lgoyes.data.wrapper.APIMovieDetailMovieWrapper
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

    override fun getMovieBudget(movie: Movie, apiKey: String, language: String): Observable<Movie> =
            mMoviesService.obtainMovieDetail(movie.movieId, apiKey, language).map {
                movie.apply {
                    budget = it.budget.toString()
                }
            }

    override fun getMovieTrailer(movie: Movie, apiKey: String): Observable<Movie> =
            mMoviesService.obtainMovieVideos(movie.movieId, apiKey).map { response ->
                movie.apply {
                    trailerLink = response.results[0].key
                }
            }
}
