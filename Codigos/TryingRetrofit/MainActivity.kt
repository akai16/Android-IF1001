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




        button_quote.setOnClickListener {
            val randomQuoteCall = RetrofitInitializer().quoteService().getRandomQuote()
            randomQuoteCall.enqueue(object : Callback<List<Quote>> {
                override fun onResponse(call: Call<List<Quote>>?, response: Response<List<Quote>>?) {
                    response?.body()?.let {
                        val quote: Quote? = it[0]

                        val re = Regex("<.*?>") //Get away with HTML Tags

                        val content = re.replace(quote!!.content, "")

                        quote_text.text = content
                        author.text = quote.title
                    }
                }

                override fun onFailure(call: Call<List<Quote>>?, t: Throwable?) {
                    quote_text.text = "Erro na conexão"
                    author.text = ""
                }
            })
        }


    }
}


