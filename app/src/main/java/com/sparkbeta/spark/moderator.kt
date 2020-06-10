package com.sparkbeta.spark

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.atifsoftwares.animatoolib.Animatoo

class moderator : AppCompatActivity() {
    private var cricket1: Button? = null
    private var football1: Button? = null
    private var kho_kho1: Button? = null
    private var badminton1: Button? = null
    private var kabaddi1: Button? = null
    private var volleyball1: Button? = null
    private var hockey: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Animatoo.animateFade(this)
        setContentView(R.layout.activity_moderator)

        cricket1 = findViewById(R.id.cricket)
        football1 = findViewById(R.id.fotball)
        kho_kho1 = findViewById(R.id.kho_kho)
        kabaddi1 = findViewById(R.id.kabaddi)
        badminton1 = findViewById(R.id.badminton)
        volleyball1 = findViewById(R.id.volleyball)
        hockey = findViewById(R.id.hockey)

        cricket1?.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this@moderator, mode::class.java)
            startActivity(intent, options.toBundle())
        }

        football1?.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this@moderator, football_bd::class.java)
            startActivity(intent, options.toBundle())
        }
        kho_kho1?.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this@moderator, kho_kho_bd::class.java)
            startActivity(intent, options.toBundle())
        }
        kabaddi1?.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this@moderator, kabaddi_bd::class.java)
            startActivity(intent, options.toBundle())
        }
        badminton1?.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this@moderator, badminton_bd::class.java)
            startActivity(intent, options.toBundle())
        }
        volleyball1?.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this@moderator, volleyball_bd::class.java)
            startActivity(intent, options.toBundle())
        }
        hockey?.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this@moderator, hockey_bd::class.java)
            startActivity(intent, options.toBundle())
        }
    }
}
