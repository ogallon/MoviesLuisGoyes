package io.condorlabs.lgoyes.data.mappers

import io.condorlabs.lgoyes.data.models.APIMovieDetail
import io.condorlabs.lgoyes.domain.models.MovieDetail
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
object APIMovieDetailMovieDetailMapper: Function<APIMovieDetail, MovieDetail> {

    override fun apply(t: APIMovieDetail): MovieDetail {
        val genres = t.genres.map {
            APIGenreGenreMapper.apply(it)
        }

        return MovieDetail(t.adult, t.backdropPath, t.belongsToCollection, t.budget, genres,
                t.homepage, t.id, t.imdbId, t.originalLanguage, t.originalTitle, t.overview,
                t.popularity, t.posterPath, t.productionCompanies, t.productionCountries,
                t.releaseDate, t.revenue, t.runtime)
    }
}
