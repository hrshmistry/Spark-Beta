package com.sparkbeta.spark

import android.app.ActivityOptions
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.google.android.material.navigation.NavigationView
import java.util.*

class Main2Activity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val items = ArrayList<app>()

        items.add(app("CRICKET", R.mipmap.cricketrv))
        items.add(app("FOOTBALL", R.mipmap.footballrv))
        items.add(app("KHO-KHO", R.mipmap.khokhorv))
        items.add(app("BADMINTON", R.mipmap.badmintonrv))
        items.add(app("KABADDI", R.mipmap.kabaddirv))
        items.add(app("VOLLEYBALL", R.mipmap.volleyballrv))
        items.add(app("HOCKEY", R.mipmap.hockeyrv))



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
                val options = ActivityOptions.makeSceneTransitionAnimation(this)
                val intent = Intent(this@Main2Activity, AboutUs::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent, options.toBundle())
            }
            R.id.nav_messages -> {
                startActivity(Intent(this@Main2Activity, SignIn::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                Animatoo.animateZoom(this)
            }
            R.id.share -> {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.sparksecure.spark")
                startActivity(Intent.createChooser(shareIntent,"Spark"))
            }
            R.id.schedule_display -> {
                val openURL = Intent(Intent.ACTION_VIEW)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                openURL.data = Uri.parse("https://sparksecure.live/pages/schedule.html")
                startActivity(openURL)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}


