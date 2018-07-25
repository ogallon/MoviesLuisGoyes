package io.condorlabs.lgoyes.domain.repositories

import io.condorlabs.lgoyes.domain.WEB_REPOSITORY_DEFAULT_LANGUAGE
import io.condorlabs.lgoyes.domain.WEB_REPOSITORY_DEFAULT_PAGE
import io.condorlabs.lgoyes.domain.models.Movie
import io.reactivex.Observable

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
interface IWebRepository {

    fun getListPopularMovies(apiKey: String,
                             language: String = WEB_REPOSITORY_DEFAULT_LANGUAGE,
                             page: String = WEB_REPOSITORY_DEFAULT_PAGE): Observable<List<Movie>>

    fun getMovieBudget(movie: Movie,
                       apiKey: String,
                       language: String = WEB_REPOSITORY_DEFAULT_LANGUAGE): Observable<Movie>

    fun getMovieTrailer(movie: Movie,
                        apiKey: String): Observable<Movie>
}
