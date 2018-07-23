package io.condorlabs.lgoyes.data.models.detailutils

import com.google.gson.annotations.SerializedName

data class APIProductionCompany(
        val id: Int,
        @SerializedName("logo_path")
        val logoPath: String,
        val name: String,
        @SerializedName("origin_country")
        val originCountry: String
)
