package io.condorlabs.lgoyes.domain.models.detailutils

import com.google.gson.annotations.SerializedName

data class SpokenLanguage(
        @SerializedName("iso_639_1")
        val iso639: String,
        val name: String
)
