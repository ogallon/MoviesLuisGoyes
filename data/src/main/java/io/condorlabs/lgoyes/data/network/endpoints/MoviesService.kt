package io.condorlabs.lgoyes.data.network.endpoints

import io.condorlabs.lgoyes.data.models.APIMovie
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
interface MoviesService {
    
    @GET("movie/popular")
    fun obtainPopularMovies(): Observable<List<APIMovie>>
}
