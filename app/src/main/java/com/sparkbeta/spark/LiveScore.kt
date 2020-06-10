package com.sparkbeta.spark

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_livescore.*

class LiveScoreFragment : Fragment() {

    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var crickScore: TextView
    private lateinit var runPerOver: TextView
    private lateinit var forPlayer1: TextView
    private lateinit var forPlayer2: TextView
    private lateinit var toss: TextView
    private var tempScore = ""
    private var tempBall = ""
    private var tempWicket = ""
    private var toss_info:String?=null
    private var need1_score:Int?=null
    private var win_score:Int?=null
    var strike1:ImageView?=null
    var strike2:ImageView?=null
    private var current_p=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Fragment.
        // val manager: FragmentManager = getSupportFragmentManager()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


//        Inflate the layout for this fragment
//        runPerOver = getView().findViewById(R.id.runPerOver)
//        runPerOver.setOnClickListener{
//            runPerOver.text = "here we go"
//        }
        return inflater.inflate(R.layout.fragment_livescore, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //   runPerOver.text= "hey"
        MobileAds.initialize(context,getString(R.string.admob_banner_ad))
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        strike1=view?.findViewById(R.id.strike1)
        strike2=view?.findViewById(R.id.strike2)

        imageView1 = view?.findViewById(R.id.imageView2)
        imageView2 = view?.findViewById(R.id.imageView3)
        crickScore = view?.findViewById(R.id.crickScore)
        runPerOver = view?.findViewById(R.id.runPerOver)
        forPlayer1 = view?.findViewById(R.id.forPlayer1)
        forPlayer2 = view?.findViewById(R.id.forPlayer2)
        toss = view?.findViewById(R.id.toss_info)

        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("cricket").child("finalScore")

        val database1 = FirebaseDatabase.getInstance().getReference("cricket").child("lastUpdatedRun")
        var current=database1.child("Current_player")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var tm1Name = dataSnapshot.child("team1Name").getValue(String::class.java).toString()
                var tm2Name = dataSnapshot.child("team2Name").getValue(String::class.java).toString()

                tempScore = dataSnapshot.child("score").getValue(Int::class.java).toString()
                tempBall = dataSnapshot.child("ball").getValue(Int::class.java)!!.toString()
                tempWicket = dataSnapshot.child("wicket").getValue(Int::class.java)!!.toString()
                toss_info = dataSnapshot.child("toss").getValue(String::class.java)!!
                need1_score= dataSnapshot.child("need_score").getValue(Int::class.java)!!
                win_score=dataSnapshot.child("win_score").getValue(Int::class.java)!!

                if (tm1Name == "null")
                    tm1Name = ""
                if (tm2Name == "null")
                    tm2Name = ""

                if(toss_info=="") {
                    toss?.text = ""
                }
                else{
                    toss?.text=toss_info
                }
                if(need1_score!=0 && need1_score!!>0 && win_score!=0){
                    toss?.text="$need1_score runs needed to win"
                }
                else if(need1_score==-2 && win_score!=0 && win_score!=tempScore.toInt()){
                    toss?.text="Balling team \n won the match"
                }
                else if(need1_score==-1 && win_score!=0 && win_score!=tempScore.toInt()){
                    toss?.text="Batting team \n won the match"
                }

                if (tempBall == "null")
                    tempBall = "0"

                val x = tempBall.toFloat()
                val y = ((x % 6) / 10)
                val w = (x / 6).toInt()
                val z = w + y

                val tempp = "$tempScore/$tempWicket($z)"
                crickScore?.text = tempp

                if (tm1Name == "IT")
                    imageView1?.setImageResource(R.mipmap.itdept)
                if (tm1Name == "MECH")
                    imageView1?.setImageResource(R.mipmap.mechdept)
                if (tm1Name == "CE")
                    imageView1?.setImageResource(R.mipmap.compdept)
                if (tm1Name == "EE")
                    imageView1?.setImageResource(R.mipmap.eledept)
                if (tm1Name == "EC")
                    imageView1?.setImageResource(R.mipmap.ecdept)
                if (tm1Name == "IC")
                    imageView1?.setImageResource(R.mipmap.icdept)
                if (tm1Name == "CIVIL")
                    imageView1?.setImageResource(R.mipmap.civildept)
                if (tm1Name == "ARCHI")
                    imageView1?.setImageResource(R.mipmap.archidept)
                if (tm1Name == "AERO")
                    imageView1?.setImageResource(R.mipmap.aerodept)
                if (tm1Name == "MCA")
                    imageView1?.setImageResource(R.mipmap.mcadept)
                if (tm1Name == "OTHER")
                    imageView1?.setImageResource(R.mipmap.others)

                if (tm2Name == "IT")
                    imageView2?.setImageResource(R.mipmap.itdept)
                if (tm2Name == "MECH")
                    imageView2?.setImageResource(R.mipmap.mechdept)
                if (tm2Name == "CE")
                    imageView2?.setImageResource(R.mipmap.compdept)
                if (tm2Name == "EE")
                    imageView2?.setImageResource(R.mipmap.eledept)
                if (tm2Name == "EC")
                    imageView2?.setImageResource(R.mipmap.ecdept)
                if (tm2Name == "IC")
                    imageView2?.setImageResource(R.mipmap.icdept)
                if (tm2Name == "CIVIL")
                    imageView2?.setImageResource(R.mipmap.civildept)
                if (tm2Name == "ARCHI")
                    imageView2?.setImageResource(R.mipmap.archidept)
                if (tm2Name == "AERO")
                    imageView2?.setImageResource(R.mipmap.aerodept)
                if (tm2Name == "MCA")
                    imageView2?.setImageResource(R.mipmap.mcadept)
                if (tm2Name == "OTHER")
                    imageView2?.setImageResource(R.mipmap.others)

            }
            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }
        })

        database1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var lastUpdateCount = dataSnapshot.child("lastUpdatedCount").getValue(Int::class.java).toString()
                var one = dataSnapshot.child("1").getValue(String::class.java).toString()
                var two = dataSnapshot.child("2").getValue(String::class.java).toString()
                var three = dataSnapshot.child("3").getValue(String::class.java).toString()
                var four = dataSnapshot.child("4").getValue(String::class.java).toString()
                var five = dataSnapshot.child("5").getValue(String::class.java).toString()
                var six = dataSnapshot.child("6").getValue(String::class.java).toString()
                var seven = dataSnapshot.child("7").getValue(String::class.java).toString()
                var eight = dataSnapshot.child("8").getValue(String::class.java).toString()
                var nine = dataSnapshot.child("9").getValue(String::class.java).toString()
                var ten = dataSnapshot.child("10").getValue(String::class.java).toString()
                var extraCount = dataSnapshot.child("extraCount").getValue(Int::class.java)?.toInt()
                var player1 = dataSnapshot.child("Player-1").getValue(Int::class.java).toString()
                var player1Name = dataSnapshot.child("player1Name").getValue(String::class.java).toString()
                var player2 = dataSnapshot.child("Player-2").getValue(Int::class.java).toString()
                var player2Name = dataSnapshot.child("player2Name").getValue(String::class.java).toString()
                if (one == "null")
                    one = "0"
                if (two == "null")
                    two = "0"
                if (three == "null")
                    three = "0"
                if (four == "null")
                    four = "0"
                if (five == "null")
                    five = "0"
                if (six == "null")
                    six = "0"
                if (seven == "null")
                    seven = "0"
                if (eight == "null")
                    eight = "0"
                if (nine == "null")
                    nine = "0"
                if (ten == "null")
                    ten = "0"
                if (lastUpdateCount == "null")
                    lastUpdateCount = "0"
                if (extraCount == null)
                    extraCount = 0
                if (player1 == "null")
                    player1 = "0"
                if (player2 == "null")
                    player2 = "0"
                if (player1Name == "null")
                    player1Name = " "
                if (player2Name == "null")
                    player2Name = " "

                var temppp = ""

                if (lastUpdateCount == "1")
                    temppp = one
                else if (lastUpdateCount == "2")
                    temppp = "$one $two"
                else if (lastUpdateCount == "3")
                    temppp = "$one $two $three"
                else if (lastUpdateCount == "4")
                    temppp = "$one $two $three $four"
                else if (lastUpdateCount == "5")
                    temppp = "$one $two $three $four $five"
                else if (lastUpdateCount == "6")
                    temppp = "$one $two $three $four $five $six"
                else if (lastUpdateCount == "7")
                    temppp = "$one $two $three $four $five $six $seven"
                else if (lastUpdateCount == "8")
                    temppp = "$one $two $three $four $five $six $seven $eight"
                else if (lastUpdateCount == "9")
                    temppp = "$one $two $three $four $five $six $seven $eight $nine"
                else if (lastUpdateCount == "10")
                    temppp = "$one $two $three $four $five $six $seven $eight $nine $ten"

                else
                    temppp = "$one $two $three $four $five $six"
                val temp1Name = "$player1Name : $player1"
                val temp2Name = "$player2Name : $player2"
                runPerOver?.text = temppp
                forPlayer1?.text = temp1Name
                forPlayer2?.text = temp2Name
            }
            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }
        })
        current.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(ds: DataSnapshot) {
                current_p = ds.getValue(String::class.java).toString()
                if(current_p=="1"){
                    strike1?.visibility=View.VISIBLE
                    strike2?.visibility=View.INVISIBLE
                    //Toast.makeText(applicationContext, current_p, Toast.LENGTH_SHORT).show()
                }
                else if(current_p=="0"){
                    strike2?.visibility=View.VISIBLE
                    strike1?.visibility=View.INVISIBLE
                    //Toast.makeText(applicationContext, current_p, Toast.LENGTH_SHORT).show()
                }
                //Toast.makeText(applicationContext, current_p, Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }
        })
    }
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------
