package com.example.samplefreedot.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.samplefreedot.R

class SplashActivity : AppCompatActivity() {
    private val time : Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()
        },time)

    }

}