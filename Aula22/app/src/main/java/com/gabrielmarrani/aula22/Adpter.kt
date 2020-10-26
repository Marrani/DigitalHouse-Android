package com.gabrielmarrani.aula22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adpter(private val dataSet:List<String>): RecyclerView.Adapter<Adpter.MeuViewHolder>() {

    class MeuViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val meuTexto by lazy {view.findViewById<TextView>(R.id.txtLista)}

        fun bind(string: String) {
            meuTexto.text = string
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_itens_lista, parent, false)
        return MeuViewHolder(view)
    }

    override fun getItemCount() = dataSet.size


    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

}