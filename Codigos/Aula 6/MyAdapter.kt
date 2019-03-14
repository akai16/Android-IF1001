package com.example.gfg2.helloworld2

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_bandas.view.*

class MyAdapter(private val lista: List<Bandas>, private val context: Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_bandas, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, position: Int) {
        val banda  = lista[position]
        p0.tv_nome.text = banda.nome
        p0.tv_genero.text = banda.genero
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_nome = itemView.tv_nome_banda
        val tv_genero = itemView.tv_genero_banda
    }

}


