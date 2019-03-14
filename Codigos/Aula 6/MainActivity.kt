package com.example.gfg2.helloworld2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista = listOf(Bandas("The Clash", "Punk"), Bandas("Cranberries", "Rock"), Bandas("Mc Racionais","Rap"))

        recycler_view.adapter = MyAdapter(lista, this)
        recycler_view.layoutManager = LinearLayoutManager(this)


    }

}
