package com.sparkbeta.spark

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long=3000 // 3 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            startActivity(Intent(this, Main2Activity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))

            finish()
        }, SPLASH_TIME_OUT)
    }
}
