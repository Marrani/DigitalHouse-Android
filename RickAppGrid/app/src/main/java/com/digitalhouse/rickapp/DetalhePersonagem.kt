package com.digitalhouse.rickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetalhePersonagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_personagem)

        val imagem = intent.getStringExtra("IMAGEM")
        val nome = intent.getStringExtra("NOME")
        val genero = intent.getStringExtra("GENERO")
        val planeta = intent.getStringExtra("SEXO")

        findViewById<TextView>(R.id.txtNome).text = nome
        findViewById<TextView>(R.id.txtGenero).text = genero
        findViewById<TextView>(R.id.txtPlaneta).text = planeta

        Picasso.get()
            .load(imagem)
            .into(findViewById<ImageView>(R.id.imgFoto))
    }
}