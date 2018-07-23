package io.condorlabs.lgoyes.data.mappers

import io.condorlabs.lgoyes.data.models.detailutils.APIGenre
import io.condorlabs.lgoyes.domain.models.detailutils.Genre
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
object APIGenreGenreMapper : Function<APIGenre, Genre> {
    override fun apply(t: APIGenre): Genre {
        return Genre(t.id, t.name)
    }
}
