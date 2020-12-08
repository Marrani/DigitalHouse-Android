package com.gabrielmarrani.aula41

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.gabrielmarrani.aula41.MainActivity.Companion.CHAVE


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val pref = getSharedPreferences("Aula41", Context.MODE_PRIVATE)
        val valor = pref.getBoolean(CHAVE, false)

        val timeSplashScreen: Long = 3500


        Handler(Looper.getMainLooper()).postDelayed({
            if(valor){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }, timeSplashScreen)
    }
}