package com.example.spark

import android.os.Bundle
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
}
