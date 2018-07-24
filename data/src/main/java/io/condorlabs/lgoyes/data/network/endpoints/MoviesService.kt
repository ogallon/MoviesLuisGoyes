package io.condorlabs.lgoyes.data.network.endpoints

import io.condorlabs.lgoyes.data.models.APIMovieDetail
import io.condorlabs.lgoyes.data.models.APIPopularMoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
interface MoviesService {

    @GET("movie/popular")
    fun obtainPopularMovies(@Query("api_key") apiKey: String,
                            @Query("language") language: String,
                            @Query("page") page: String): Observable<APIPopularMoviesResponse>

    @GET("movie/{movieId}")
    fun obtainMovieDetail(@Path("movieId") movieId: String,
                          @Query("api_key") apiKey: String,
                          @Query("language") language: String): Observable<APIMovieDetail>

    @GET("movie/{movieId}/videos")
    fun obtainMovieVideos(@Path("movieId") movieId: String,
                          @Query("api_key") apiKey: String): Observable<APIMovieDetail>
}
