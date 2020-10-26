package com.gabrielmarrani.aula21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFragA.setOnClickListener {

            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.container, MeuPrimeiroFragment())
            transaction.commit()

        }

       btnFragB.setOnClickListener {
           val manager = supportFragmentManager
           val transaction = manager.beginTransaction()
           transaction.replace(R.id.container, MeuSegundoFragment())
           transaction.commit()

        }


    }

}