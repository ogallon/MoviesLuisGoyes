package io.condorlabs.lgoyes.domain.models.detailutils

import com.google.gson.annotations.SerializedName

data class ProductionCompany(
        val id: Int,
        @SerializedName("logo_path")
        val logoPath: String,
        val name: String,
        @SerializedName("origin_country")
        val originCountry: String
)
