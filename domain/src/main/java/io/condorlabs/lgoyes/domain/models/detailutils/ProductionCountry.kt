package io.condorlabs.lgoyes.domain.models.detailutils

import com.google.gson.annotations.SerializedName

data class ProductionCountry(
        @SerializedName("iso_3166_1")
        val iso3166: String,
        val name: String
)
