package io.condorlabs.lgoyes.data.mappers

import io.condorlabs.lgoyes.data.models.detailutils.APIProductionCompany
import io.condorlabs.lgoyes.domain.models.detailutils.ProductionCompany
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
object APIProductionCompanyProductionCompanyMapper : Function<APIProductionCompany, ProductionCompany> {
    override fun apply(t: APIProductionCompany): ProductionCompany {
        return ProductionCompany( t.id, t.logoPath, t.name, t.originCountry )
    }
}
