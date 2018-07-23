package io.condorlabs.lgoyes.data.models.detail

import com.google.gson.annotations.SerializedName

data class SpokenLanguage(
        @SerializedName("iso_639_1")
        val iso639: String,
        val name: String
)
