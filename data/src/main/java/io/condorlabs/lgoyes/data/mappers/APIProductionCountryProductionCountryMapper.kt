package io.condorlabs.lgoyes.data.mappers

import io.condorlabs.lgoyes.data.models.detailutils.APIProductionCountry
import io.condorlabs.lgoyes.domain.models.detailutils.ProductionCountry
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
object APIProductionCountryProductionCountryMapper : Function<APIProductionCountry, ProductionCountry> {
    override fun apply(t: APIProductionCountry): ProductionCountry {
        return ProductionCountry(t.iso3166, t.name)
    }
}
