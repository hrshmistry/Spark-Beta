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

//    private lateinit var imageView1: ImageView
//    private lateinit var imageView2: ImageView
//    private lateinit var crickScore: TextView
//    private lateinit var runPerOver: TextView
//    private lateinit var forPlayer1: TextView
//    private lateinit var forPlayer2: TextView
//    private lateinit var toss: TextView
//    private var tempScore = ""
//    private var tempBall = ""
//    private var tempWicket = ""
//    private var toss_info:String?=null
//    private var need1_score:Int?=null
//    private var win_score:Int?=null

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

//        nameA=findViewById(R.id.team_name)
//        nameB=findViewById(R.id.team_name)
//
//        val database1:FirebaseDatabase = FirebaseDatabase.getInstance()
//        val nameARef: DatabaseReference = database1.getReference("cricket").child("Team A").child("NameA")
//
//        nameARef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                nameA?.text = dataSnapshot.getValue(String::class.java)!!
//            }
//
//            override fun onCancelled(error: DatabaseError) { // Failed to read value
//                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
//            }
//        })
//
//        val nameBRef: DatabaseReference = database1.getReference("cricket").child("Team B").child("NameB")
//
//        nameBRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                nameB?.text = dataSnapshot.getValue(String::class.java)!!
//            }
//
//            override fun onCancelled(error: DatabaseError) { // Failed to read value
//                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
//            }
//        })

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

//        val scoreboard1=findViewById<Button>(R.id.team1)
//        val scoreboard2=findViewById<Button>(R.id.team2)
//
//        scoreboard1.setOnClickListener {
//            val options = ActivityOptions.makeSceneTransitionAnimation(this)
//            val intent = Intent(this@MainActivity, team1_details::class.java)
//            startActivity(intent, options.toBundle())
//        }
//
//        scoreboard2.setOnClickListener {
//            val options = ActivityOptions.makeSceneTransitionAnimation(this)
//            val intent = Intent(this@MainActivity, team2_details::class.java)
//            startActivity(intent, options.toBundle())
//        }
//
//        imageView1 = findViewById(R.id.imageView2)
//        imageView2 = findViewById(R.id.imageView3)
//        crickScore = findViewById(R.id.crickScore)
//        runPerOver = findViewById(R.id.runPerOver)
//        forPlayer1 = findViewById(R.id.forPlayer1)
//        forPlayer2 = findViewById(R.id.forPlayer2)
//        toss = findViewById(R.id.toss_info)
//
//        val database = FirebaseDatabase.getInstance()
//        val reference = database.getReference("cricket").child("finalScore")
//
//        val database1 = FirebaseDatabase.getInstance().getReference("cricket").child("lastUpdatedRun")
//
//        reference.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//
//                var tm1Name = dataSnapshot.child("team1Name").getValue(String::class.java).toString()
//                var tm2Name = dataSnapshot.child("team2Name").getValue(String::class.java).toString()
//
//                tempScore = dataSnapshot.child("score").getValue(Int::class.java).toString()
//                tempBall = dataSnapshot.child("ball").getValue(Int::class.java)!!.toString()
//                tempWicket = dataSnapshot.child("wicket").getValue(Int::class.java)!!.toString()
//                toss_info = dataSnapshot.child("toss").getValue(String::class.java)!!
//                need1_score= dataSnapshot.child("need_score").getValue(Int::class.java)!!
//                win_score=dataSnapshot.child("win_score").getValue(Int::class.java)!!
//
//                if (tm1Name == "null")
//                    tm1Name = ""
//                if (tm2Name == "null")
//                    tm2Name = ""
//
//                if(toss_info=="") {
//                    toss.text = ""
//                }
//                else{
//                    toss.text=toss_info
//                }
//                if(need1_score!=0 && need1_score!!>0 && win_score!=0){
//                    toss.text="$need1_score runs needed to win"
//                }
//                else if(need1_score==-2 && win_score!=0 && win_score!=tempScore.toInt()){
//                    toss.text="Balling team \n won the match"
//                }
//                else if(need1_score==-1 && win_score!=0 && win_score!=tempScore.toInt()){
//                    toss.text="Batting team \n won the match"
//                }
//
//                if (tempBall == "null")
//                    tempBall = "0"
//
//                val x = tempBall.toFloat()
//                val y = ((x % 6) / 10)
//                val w = (x / 6).toInt()
//                val z = w + y
//
//                val tempp = "$tempScore/$tempWicket($z)"
//                crickScore.text = tempp
//
//                if (tm1Name == "IT")
//                    imageView1.setImageResource(R.mipmap.itdept)
//                if (tm1Name == "MECH")
//                    imageView1.setImageResource(R.mipmap.mechdept)
//                if (tm1Name == "CE")
//                    imageView1.setImageResource(R.mipmap.compdept)
//                if (tm1Name == "EE")
//                    imageView1.setImageResource(R.mipmap.electdept)
//                if (tm1Name == "EC")
//                    imageView1.setImageResource(R.mipmap.ecdept)
//                if (tm1Name == "IC")
//                    imageView1.setImageResource(R.mipmap.icdept)
//                if (tm1Name == "CIVIL")
//                    imageView1.setImageResource(R.mipmap.civildept)
//                if (tm1Name == "ARCHI")
//                    imageView1.setImageResource(R.mipmap.archidept)
//                if (tm1Name == "AERO")
//                    imageView1.setImageResource(R.mipmap.aerodept)
//
//                if (tm2Name == "IT")
//                    imageView2.setImageResource(R.mipmap.itdept)
//                if (tm2Name == "MECH")
//                    imageView2.setImageResource(R.mipmap.mechdept)
//                if (tm2Name == "CE")
//                    imageView2.setImageResource(R.mipmap.compdept)
//                if (tm2Name == "EE")
//                    imageView2.setImageResource(R.mipmap.electdept)
//                if (tm2Name == "EC")
//                    imageView2.setImageResource(R.mipmap.ecdept)
//                if (tm2Name == "IC")
//                    imageView2.setImageResource(R.mipmap.icdept)
//                if (tm2Name == "CIVIL")
//                    imageView2.setImageResource(R.mipmap.civildept)
//                if (tm2Name == "ARCHI")
//                    imageView2.setImageResource(R.mipmap.archidept)
//                if (tm2Name == "AERO")
//                    imageView2.setImageResource(R.mipmap.aerodept)
//
//            }
//            override fun onCancelled(p0: DatabaseError) {
//                Log.d("Exception", p0.message)
//            }
//
//
//        })
//
//        database1.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                var lastUpdateCount = dataSnapshot.child("lastUpdatedCount").getValue(Int::class.java).toString()
//                var one = dataSnapshot.child("1").getValue(String::class.java).toString()
//                var two = dataSnapshot.child("2").getValue(String::class.java).toString()
//                var three = dataSnapshot.child("3").getValue(String::class.java).toString()
//                var four = dataSnapshot.child("4").getValue(String::class.java).toString()
//                var five = dataSnapshot.child("5").getValue(String::class.java).toString()
//                var six = dataSnapshot.child("6").getValue(String::class.java).toString()
//                var seven = dataSnapshot.child("7").getValue(String::class.java).toString()
//                var eight = dataSnapshot.child("8").getValue(String::class.java).toString()
//                var nine = dataSnapshot.child("9").getValue(String::class.java).toString()
//                var ten = dataSnapshot.child("10").getValue(String::class.java).toString()
//                var extraCount = dataSnapshot.child("extraCount").getValue(Int::class.java)?.toInt()
//                var player1 = dataSnapshot.child("Player-1").getValue(Int::class.java).toString()
//                var player1Name = dataSnapshot.child("player1Name").getValue(String::class.java).toString()
//                var player2 = dataSnapshot.child("Player-2").getValue(Int::class.java).toString()
//                var player2Name = dataSnapshot.child("player2Name").getValue(String::class.java).toString()
//                if (one == "null")
//                    one = "0"
//                if (two == "null")
//                    two = "0"
//                if (three == "null")
//                    three = "0"
//                if (four == "null")
//                    four = "0"
//                if (five == "null")
//                    five = "0"
//                if (six == "null")
//                    six = "0"
//                if (seven == "null")
//                    seven = "0"
//                if (eight == "null")
//                    eight = "0"
//                if (nine == "null")
//                    nine = "0"
//                if (ten == "null")
//                    ten = "0"
//                if (lastUpdateCount == "null")
//                    lastUpdateCount = "0"
//                if (extraCount == null)
//                    extraCount = 0
//                if (player1 == "null")
//                    player1 = "0"
//                if (player2 == "null")
//                    player2 = "0"
//                if (player1Name == "null")
//                    player1Name = " "
//                if (player2Name == "null")
//                    player2Name = " "
//
//                var temppp = ""
//
//                if (lastUpdateCount == "1")
//                    temppp = one
//                else if (lastUpdateCount == "2")
//                    temppp = "$one $two"
//                else if (lastUpdateCount == "3")
//                    temppp = "$one $two $three"
//                else if (lastUpdateCount == "4")
//                    temppp = "$one $two $three $four"
//                else if (lastUpdateCount == "5")
//                    temppp = "$one $two $three $four $five"
//                else if (lastUpdateCount == "6")
//                    temppp = "$one $two $three $four $five $six"
//                else if (lastUpdateCount == "7")
//                    temppp = "$one $two $three $four $five $six $seven"
//                else if (lastUpdateCount == "8")
//                    temppp = "$one $two $three $four $five $six $seven $eight"
//                else if (lastUpdateCount == "9")
//                    temppp = "$one $two $three $four $five $six $seven $eight $nine"
//                else if (lastUpdateCount == "10")
//                    temppp = "$one $two $three $four $five $six $seven $eight $nine $ten"
//
//                else
//                    temppp = "$one $two $three $four $five $six"
//                val temp1Name = "$player1Name : $player1"
//                val temp2Name = "$player2Name : $player2"
//                runPerOver.text = temppp
//                forPlayer1.text = temp1Name
//                forPlayer2.text = temp2Name
//
//
//
//            }
//            override fun onCancelled(p0: DatabaseError) {
//                Log.d("Exception", p0.message)
//            }
//        })
//        val schedule : TextView = findViewById(R.id.schedule6)
//        val urls = "https://www.tutorialspoint.com/java/index.htm"
//        schedule.setOnClickListener{
//            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urls)))
//        }
}
