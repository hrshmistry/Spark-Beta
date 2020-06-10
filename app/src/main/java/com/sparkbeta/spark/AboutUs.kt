package com.sparkbeta.spark

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
//This file shows the status of all the team members who put thier josh together for building this application ##
class AboutUs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us2)

        val schedule : TextView = findViewById(R.id.textGrid3)
        val urls = "https://sparksecure.live/"

        schedule.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urls)))
        }
    }
}
