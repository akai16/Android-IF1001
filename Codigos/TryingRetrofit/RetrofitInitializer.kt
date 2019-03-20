package com.example.gfg2.projetoteste

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://quotesondesign.com/wp-json/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun quoteService() = this.retrofit.create(QuoteService::class.java)

}