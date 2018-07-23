package io.condorlabs.lgoyes.data.repositories

import io.condorlabs.lgoyes.data.mappers.APIMovieDetailMovieDetailMapper
import io.condorlabs.lgoyes.data.mappers.APIMovieMovieMapper
import io.condorlabs.lgoyes.data.mappers.APIPopularMoviesResponsePopularMoviesResponseMapper
import io.condorlabs.lgoyes.data.network.endpoints.MoviesService
import io.condorlabs.lgoyes.domain.models.Movie
import io.condorlabs.lgoyes.domain.models.MovieDetail
import io.condorlabs.lgoyes.domain.models.PopularMoviesResponse
import io.condorlabs.lgoyes.domain.repositories.IWebRepository
import io.reactivex.Observable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
class WebRepository(private val mMoviesService: MoviesService) : IWebRepository {
    override fun getListPopularMovies(apiKey: String, language: String, page: String): Observable<PopularMoviesResponse> =
            mMoviesService.obtainPopularMovies(apiKey, language, page).map {
                APIPopularMoviesResponsePopularMoviesResponseMapper.apply(it)
            }

    override fun getMovieDetails(movieId: String, apiKey: String, language: String): Observable<MovieDetail> =
            mMoviesService.obtainMovieDetail(movieId, apiKey, language).map {
                APIMovieDetailMovieDetailMapper.apply(it)
            }
}
