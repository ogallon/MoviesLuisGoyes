package io.condorlabs.lgoyes.data.mappers

import io.condorlabs.lgoyes.data.models.detailutils.APISpokenLanguage
import io.condorlabs.lgoyes.domain.models.detailutils.SpokenLanguage
import io.reactivex.functions.Function

/**
 * @author Luis Goyes (lgoyes@condorlabs.io) on July/23/2018
 */
object APISpokenLanguageSpokenLanguageMapper : Function<APISpokenLanguage, SpokenLanguage> {
    override fun apply(t: APISpokenLanguage): SpokenLanguage {
        return SpokenLanguage(t.iso639, t.name)
    }
}
