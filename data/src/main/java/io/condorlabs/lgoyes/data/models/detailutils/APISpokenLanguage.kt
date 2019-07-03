package io.condorlabs.lgoyes.data.models.detailutils

import com.google.gson.annotations.SerializedName

data class APISpokenLanguage(
        @SerializedName("iso_639_1")
        val iso639: String,
        val name: String
)
