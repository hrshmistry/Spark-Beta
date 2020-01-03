package com.example.spark

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val items = ArrayList<app>()

        items.add(app("Cricket", R.drawable.four))
        items.add(app("Football", R.drawable.three))
        items.add(app("Kho-Kho", R.drawable.eight))
        items.add(app("Badminton", R.drawable.five))
        items.add(app("Kabaddi", R.drawable.six))
        items.add(app("VolleyBall", R.drawable.seven))


        val apps = findViewById<RecyclerView>(R.id.recycle_apps)
        val adapter = adapter(items, applicationContext)

        apps.layoutManager = GridLayoutManager(applicationContext, 2)
        apps.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.jj, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btnSignin -> {
                startActivity(Intent(this@Main2Activity, SignIn::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}
