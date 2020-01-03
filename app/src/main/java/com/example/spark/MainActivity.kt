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
    private var tempScore = ""
    private var tempBall = ""
    private var tempWicket = ""







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        crickScore = findViewById(R.id.crickScore)
        runPerOver = findViewById(R.id.runPerOver)


        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("finalScore")

        val database1 = FirebaseDatabase.getInstance().getReference("lastUpdatedRun")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                // for(ds in dataSnapshot.children){
                tempScore = dataSnapshot.child("score").getValue(Int::class.java).toString()
                tempBall = dataSnapshot.child("ball").getValue(Int::class.java)!!.toString()
                tempWicket = dataSnapshot.child("wicket").getValue(Int::class.java)!!.toString()
                // tempWide = dataSnapshot.child("wide").getValue(String::class.java)!!.toString()
                // tempN=  dataSnapshot.child("Noball").getValue(String::class.java)!!.toString()
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
                //if(lastUpdateCount=="7")
                //  database1.child("lastUpdateCount").setValue(lastUpdateCount)


                var temppp = ""


                if (extraCount % 6 >= 1) {
                    /*  if(lastUpdateCount == "1")
                          temppp = "$two $three $four $five $six $one"
                      if(lastUpdateCount == "2")
                          temppp = "$three $four $five $six $one $two"
                      if(lastUpdateCount == "3")
                          temppp = "$four $five $six $one $two $three"
                      if(lastUpdateCount == "4")
                          temppp = "$five $six $one $two $three $four"
                      if(lastUpdateCount == "5")
                          temppp = "$six $one $two $three $four $five"
                      if(lastUpdateCount == "6")
                          temppp = "$one $two $three $four $five $six"

                     */
                    if (lastUpdateCount == "1")
                        temppp = one
                    if (lastUpdateCount == "2")
                        temppp = "$one $two"
                    if (lastUpdateCount == "3")
                        temppp = "$one $two $three"
                    if (lastUpdateCount == "4")
                        temppp = "$one $two $three $four"
                    if (lastUpdateCount == "5")
                        temppp = "$one $two $three $four $five"
                    if (lastUpdateCount == "6")
                        temppp = "$one $two $three $four $five $six"
                    if (lastUpdateCount == "7")
                        temppp = "$one $two $three $four $five $six $seven"
                    if (lastUpdateCount == "8")
                        temppp = "$one $two $three $four $five $six $seven $eight"
                    if (lastUpdateCount == "9")
                        temppp = "$one $two $three $four $five $six $seven $eight $nine"
                    if (lastUpdateCount == "10")
                        temppp = "$one $two $three $four $five $six $seven $eight $nine $ten"
                } else
                    temppp = "$one $two $three $four $five $six"

                runPerOver.text = temppp


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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*return when (item.itemId) {
            R.id.btnSignin -> true
            else -> super.onOptionsItemSelected(item)
        }*/
        return when (item.itemId) {
            btnSignin1 -> {
                startActivity(Intent(this@MainActivity, SignIn::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}
