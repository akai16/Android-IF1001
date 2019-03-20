package com.example.gfg2.projetoteste

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface QuoteService {

    @GET("posts?filter[orderby]=rand&filter[posts_per_page]=1")
    fun getRandomQuote(): Call<List<Quote>>
}