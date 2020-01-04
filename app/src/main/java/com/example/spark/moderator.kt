package com.example.spark

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class moderator : AppCompatActivity() {
    private var cricket1: Button? = null
    private var football1: Button? = null
    private var kho_kho1: Button? = null
    private var badminton1: Button? = null
    private var kabaddi1: Button? = null
    private var volleyball1: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moderator)
        cricket1 = findViewById(R.id.cricket)
        football1 = findViewById(R.id.fotball)
        kho_kho1 = findViewById(R.id.kho_kho)
        kabaddi1 = findViewById(R.id.kabaddi)
        badminton1 = findViewById(R.id.badminton)
        volleyball1 = findViewById(R.id.volleyball)

        cricket1?.setOnClickListener {
            var intent = Intent(this@moderator, mode::class.java)
            startActivity(intent)
        }

        football1?.setOnClickListener {
            var intent = Intent(this@moderator, football_bd::class.java)
            startActivity(intent)
        }
        kho_kho1?.setOnClickListener {
            var intent = Intent(this@moderator, kho_kho_bd::class.java)
            startActivity(intent)
        }
        kabaddi1?.setOnClickListener {
            var intent = Intent(this@moderator, kabaddi_bd::class.java)
            startActivity(intent)
        }
        badminton1?.setOnClickListener {
            var intent = Intent(this@moderator, badminton_bd::class.java)
            startActivity(intent)
        }
        volleyball1?.setOnClickListener {
            var intent = Intent(this@moderator, volleyball_bd::class.java)
            startActivity(intent)
        }
    }
}
