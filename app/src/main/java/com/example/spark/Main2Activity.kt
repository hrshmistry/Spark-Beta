package com.example.spark

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_moderator.*
import java.util.*

class Main2Activity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

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

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_profile -> {
                startActivity(Intent(this@Main2Activity, mode::class.java))
            }
            R.id.nav_messages -> {
                startActivity(Intent(this@Main2Activity, badminton_bd::class.java))
            }
            R.id.nav_friends -> {
                startActivity(Intent(this@Main2Activity, kabaddi::class.java))
            }
            R.id.nav_update -> {
                startActivity(Intent(this@Main2Activity, kabaddi_bd::class.java))
            }
            R.id.nav_logout -> {
                startActivity(Intent(this@Main2Activity, SignIn::class.java))
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}


