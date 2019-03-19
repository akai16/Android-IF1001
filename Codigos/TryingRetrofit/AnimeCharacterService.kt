package com.example.gfg2.projetoteste

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeCharacterService {

    @GET("characters/{id}/?fields[characters]=name,image,description")
    fun getSingleCharacter(@Path("id") id: Int): Call<AnimeCharacter>
}