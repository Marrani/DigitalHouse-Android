package com.gabrielmarrani.aula35.categoria.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gabrielmarrani.aula35.R

class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val categoria = view.findViewById<TextView>(R.id.listCategoria)

    fun bind(nome: String) {
        categoria.text = nome.capitalize()

    }
}