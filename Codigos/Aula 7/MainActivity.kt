package com.example.gfg2.helloworld2

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = MyAdapter(Bandas.lista, this)
        recycler_view.layoutManager = LinearLayoutManager(this)

        AsyncTaskExample(this).execute()
    }

    class AsyncTaskExample(private var activity: MainActivity?) : AsyncTask<String, String, String>() {
        override fun doInBackground(vararg params: String?): String {
            var result = ""
            try {
                val url = URL("https://jsonplaceholder.typicode.com/users/1")
                val httpURLConnection = url.openConnection() as HttpURLConnection

                httpURLConnection.readTimeout = 8000
                httpURLConnection.connectTimeout = 8000
                httpURLConnection.connect()

                val responseCode: Int = httpURLConnection.responseCode
                Log.d("DeuCertoPai", "responseCode - " + responseCode)

                if (responseCode == 200 || responseCode == 304) {
                    val inStream: InputStream = httpURLConnection.inputStream
                    val isReader = InputStreamReader(inStream)
                    val bReader = BufferedReader(isReader)
                    var tempStr: String?

                    try {
                        while (true) {
                            tempStr = bReader.readLine()
                            if (tempStr == null) {
                                break
                            }
                            result += tempStr
                        }
                    } catch (Ex: Exception) {
                        Log.e("Erro", "Error in convertToString " + Ex.printStackTrace())
                    }
                }
            } catch (ex: Exception) {
                Log.d("", "Error in doInBackground " + ex.message)
            }
            return result
        }

        override fun onPreExecute() {
            super.onPreExecute()
            // ...

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (result == "") {
                activity?.text_teste?.text = "Deu erro Titio"
            } else {
                activity?.text_teste?.text = result
            }
            // ...
        }
    }

}
