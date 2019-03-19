package com.example.gfg2.projetoteste

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animeCharacterCall = RetrofitInitializer().animeCharacterService().getSingleCharacter(1)

        animeCharacterCall.enqueue(object : Callback<AnimeCharacter> {
            override fun onResponse(call: Call<AnimeCharacter>?, response: Response<AnimeCharacter>?) {
                response?.body()?.let {
                    val animeCharacter: AnimeCharacter? = it

                    character_name.text = animeCharacter?.attributes?.name
                    character_description.text = animeCharacter?.attributes?.description
                }
            }

            override fun onFailure(call: Call<AnimeCharacter>?, t: Throwable?) {
                character_name.text = "Erro na conexão"
                character_description.text=""
            }
        })
    }
}
