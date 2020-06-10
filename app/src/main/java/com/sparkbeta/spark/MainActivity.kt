package com.sparkbeta.spark

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.google.android.material.tabs.TabLayout
import com.sparkbeta.spark.R

class MainActivity : AppCompatActivity() {

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

//    private var nameA:TextView? = null
//    private var nameB:TextView? = null

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Animatoo.animateCard(this)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            val mChannel = NotificationChannel("MyNotification", "MyNotification", NotificationManager.IMPORTANCE_DEFAULT)
            //mChannel.description = descriptionText
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }

        /*FirebaseMessaging.getInstance().subscribeToTopic("sparkNotify")
            .addOnCompleteListener { task ->
                var msg = "Successful"
                if (!task.isSuccessful) {
                    msg = "failed"
                }
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            }*/

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)


        tabLayout!!.addTab(tabLayout!!.newTab().setText("Live Score"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Team A"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Team B"))

//        tabLayout!!.addTab(tabLayout!!.newTab().setText(nameA?.toString()))
//        tabLayout!!.addTab(tabLayout!!.newTab().setText(nameB?.toString()))

        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = MyAdapter(this, supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


    }
//-------------------------------------------------------------------Push Notification----------------------------------------------------------------------------------------------


//        val notificationBuilder = NotificationCompat.Builder(this, "MyNotification")
//            .setContentText("this is my text")
//            .setContentTitle("this is MyNotification title")
//            .setAutoCancel(true)
//            .setSmallIcon(R.mipmap.sparkflatlogo)
//            .setSound(defaultSoundUri)
//            .setContentIntent(pendingIntent)
//
//        val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
//
//
//        // Create an explicit intent for an Activity in your app
//        val intent = Intent(this, MainActivity::class.java).apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        }
//        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
//
//        val builder = NotificationCompat.Builder(this, 11.toString())
//            .setSmallIcon(R.drawable.sparkflatlogo)
//            .setContentTitle("My notification")
//            .setContentText("Hello World!")
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//            // Set the intent that will fire when the user taps the notification
//            .setContentIntent(pendingIntent)
//            .setAutoCancel(true)
//
//        with(NotificationManagerCompat.from(this)) {
//            // notificationId is a unique int for each notification that you must define
//            notify(11, builder.build())
//        }
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
