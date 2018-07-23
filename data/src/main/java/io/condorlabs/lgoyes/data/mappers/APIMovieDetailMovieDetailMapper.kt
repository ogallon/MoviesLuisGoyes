package io.condorlabs.lgoyes.data.mappers

import io.condorlabs.lgoyes.data.models.APIMovieDetail
import io.condorlabs.lgoyes.domain.models.MovieDetail
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
object APIMovieDetailMovieDetailMapper : Function<APIMovieDetail, MovieDetail> {

    override fun apply(t: APIMovieDetail): MovieDetail {
        val genres = t.genres.map {
            APIGenreGenreMapper.apply(it)
        }

        val productionCountries = t.productionCountries.map {
            APIProductionCountryProductionCountryMapper.apply(it)
        }

        val productionCompanies = t.productionCompanies.map {
            APIProductionCompanyProductionCompanyMapper.apply(it)
        }

        val spokenLanguages = t.spokenLanguages.map {
            APISpokenLanguageSpokenLanguageMapper.apply(it)
        }

        return MovieDetail(t.adult, t.backdropPath, t.belongsToCollection, t.budget, genres,
                t.homepage, t.id, t.imdbId, t.originalLanguage, t.originalTitle, t.overview,
                t.popularity, t.posterPath, productionCompanies, productionCountries,
                t.releaseDate, t.revenue, t.runtime, spokenLanguages, t.status, t.tagline,
                t.title, t.video, t.voteAverage, t.voteCount)
    }
}
