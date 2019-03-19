package com.example.gfg2.projetoteste

import com.google.gson.annotations.SerializedName

class AnimeCharacter(
    @SerializedName("attributes") val attributes: Attributes
)

data class Attributes (
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: CharacterImage,
    @SerializedName("description") val description: String
)


data class CharacterImage(
   @SerializedName("original") val original: String
)