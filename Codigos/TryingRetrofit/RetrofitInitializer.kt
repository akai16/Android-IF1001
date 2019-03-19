package com.example.gfg2.projetoteste

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/edge")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun animeCharacterService() = this.retrofit.create(AnimeCharacterService::class.java)

}