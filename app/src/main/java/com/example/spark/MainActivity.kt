package com.example.spark

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.spark.R.id.btnSignin as btnSignin1

class MainActivity : AppCompatActivity() {

    private lateinit var crickScore: TextView
    private lateinit var runPerOver: TextView
    private lateinit var forPlayer1: TextView
    private lateinit var forPlayer2: TextView
    private lateinit var toss: TextView
    private var tempScore = ""
    private var tempBall = ""
    private var tempWicket = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        crickScore = findViewById(R.id.crickScore)
        runPerOver = findViewById(R.id.runPerOver)
        forPlayer1 = findViewById(R.id.forPlayer1)
        forPlayer2 = findViewById(R.id.forPlayer2)
        toss = findViewById(R.id.toss_info)

        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("cricket").child("finalScore")

        val database1 =
            FirebaseDatabase.getInstance().getReference("cricket").child("lastUpdatedRun")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                // for(ds in dataSnapshot.children){
                tempScore = dataSnapshot.child("score").getValue(Int::class.java).toString()
                tempBall = dataSnapshot.child("ball").getValue(Int::class.java)!!.toString()
                tempWicket = dataSnapshot.child("wicket").getValue(Int::class.java)!!.toString()
                toss.text = dataSnapshot.child("toss").getValue(String::class.java)!!
                if (tempBall == "null")
                    tempBall = "0"
                val x = tempBall.toFloat()
                val y = ((x % 6) / 10)
                val w = (x / 6).toInt()


                val z = w + y



                val tempp = "$tempScore/$tempWicket($z)"
                crickScore.text = tempp




            }
            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }


        })



        database1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var lastUpdateCount =
                    dataSnapshot.child("lastUpdatedCount").getValue(Int::class.java).toString()
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
                var player1Name =
                    dataSnapshot.child("player1Name").getValue(String::class.java).toString()
                var player2 = dataSnapshot.child("Player-2").getValue(Int::class.java).toString()
                var player2Name =
                    dataSnapshot.child("player2Name").getValue(String::class.java).toString()
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
                //if(lastUpdateCount=="7")
                //  database1.child("lastUpdateCount").setValue(lastUpdateCount)


                var temppp = ""


                // if(extraCount%6>=1){

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
                //}

                else
                    temppp = "$one $two $three $four $five $six"
                val temp1Name = "$player1Name : $player1"
                val temp2Name = "$player2Name : $player2"
                runPerOver.text = temppp
                forPlayer1.text = temp1Name
                forPlayer2.text = temp2Name



            }
            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.jj, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            btnSignin1 -> {
                startActivity(Intent(this@MainActivity, SignIn::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}
