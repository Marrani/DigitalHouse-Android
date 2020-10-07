package com.gabrielmarrani.exercicio_conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConverter.setOnClickListener {
            var temperatura = edtTemperatura.text.toString().toInt()
            if(temperatura != null){
                val resultTemperatura = (temperatura * 9) / 5 + 32
                txtTemperatura.text = "$resultTemperatura ºF"
            }

        }
    }
}
