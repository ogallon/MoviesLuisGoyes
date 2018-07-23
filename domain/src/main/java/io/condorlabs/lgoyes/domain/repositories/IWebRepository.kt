package io.condorlabs.lgoyes.domain.repositories

import io.condorlabs.lgoyes.domain.models.Movie
import io.condorlabs.lgoyes.domain.models.MovieDetail
import io.reactivex.Observable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
interface IWebRepository {

    fun getListPopularMovies(apiKey: String,
                             language: String,
                             page: String): Observable<List<Movie>>

    fun getMovieDetails(movieId: String,
                        apiKey: String,
                        language: String): Observable<MovieDetail>
}
