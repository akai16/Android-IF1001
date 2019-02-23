package com.example.saint.projetoif1001

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val mViewHolder = ViewHolder(textInfo=this.findViewById(R.id.text_info))

        val ss:String = intent.getStringExtra("valor") ?: "Erro"


        mViewHolder.textInfo.setText(ss)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    class ViewHolder(val textInfo: TextView)


}
