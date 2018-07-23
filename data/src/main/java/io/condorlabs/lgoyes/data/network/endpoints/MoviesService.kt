package io.condorlabs.lgoyes.data.network.endpoints

import io.condorlabs.lgoyes.data.models.APIMovie
import io.condorlabs.lgoyes.data.models.APIMovieDetail
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
interface MoviesService {

    @GET("movie/popular?api_key={apiKey}&language={language}&page={page}")
    fun obtainPopularMovies(@Path("apiKey") apiKey: String,
                            @Path("language") language: String,
                            @Path("page") page: String): Observable<List<APIMovie>>

    @GET("movie/{movieId}?api_key={apiKey}&language={language}")
    fun obtainMovieDetail(@Path("movieId") movieId: String,
                          @Path("apiKey") apiKey: String,
                          @Path("language") language: String): Observable<APIMovieDetail>
}
