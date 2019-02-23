package com.example.saint.projetoif1001

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mViewHolder = ViewHolder(
                editValue = findViewById(R.id.edit_valor),
                buttonTela2 = findViewById(R.id.button_tela_2)
        )

        mViewHolder.buttonTela2.setOnClickListener {
            val text = mViewHolder.editValue.text

            val intent: Intent? = Intent(this, DetailsActivity::class.java)
            intent?.putExtra("valor", text.toString())

            startActivity(intent)
        }
    }


    data class ViewHolder(val editValue: EditText, val buttonTela2: Button)



}
