package com.gabrielmarrani.aula41

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.CheckBox
import com.google.android.material.checkbox.MaterialCheckBox
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigInteger
import java.security.MessageDigest

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val checkConectado = findViewById<MaterialCheckBox>(R.id.checkConectado)
        val pref = getSharedPreferences("Aula41", Context.MODE_PRIVATE)

        checkConectado.setOnCheckedChangeListener() { _, isChecked ->
            pref.edit().putBoolean("CHAVE", isChecked).apply()
        }

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    companion object {
        const val CHAVE = "CHAVE"

    }

}