package com.example.gfg2.helloworld2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botao.setOnClickListener { texto.text =  if (edit.text.toString() == "eae") "Suave" else edit.text }
    }

}
