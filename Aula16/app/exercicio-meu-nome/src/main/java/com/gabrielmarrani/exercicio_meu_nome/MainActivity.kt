package com.gabrielmarrani.exercicio_meu_nome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnExibir.setOnClickListener {
            var nome = edtNome.text.toString()
            txtResultNome.text = nome
        }
    }
}
