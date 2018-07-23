package io.condorlabs.lgoyes.data.models.detailutils

import com.google.gson.annotations.SerializedName

data class APIProductionCountry(
        @SerializedName("iso_3166_1")
        val iso3166: String,
        val name: String
)
