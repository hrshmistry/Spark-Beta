package com.example.spark

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_kabaddi.*

class kabaddi : AppCompatActivity() {
    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kabaddi)
        imageView1 = findViewById(R.id.team1Image)
        imageView2 = findViewById(R.id.team2Image)

        val rf = FirebaseDatabase.getInstance().getReference("Kabaddi")
        rf.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(ds: DataSnapshot) {
                var tm1 = ds.child("team1Score").getValue(Int::class.java).toString()
                var tm2 = ds.child("team2Score").getValue(Int::class.java).toString()
                var tm1Name = ds.child("team1Name").getValue(String::class.java).toString()
                var tm2Name = ds.child("team2Name").getValue(String::class.java).toString()
                var win = ds.child("win").getValue(String::class.java).toString()


                if (tm1 == "null")
                    tm1 = "0"
                if (tm2 == "null")
                    tm2 = "0"
                if (tm1Name == "null")
                    tm1Name = ""
                if (tm2Name == "null")
                    tm2Name = ""
                if (win == "null")
                    win = ""

                val temp = "$tm1 - $tm2"

                score.text = temp
                if (win == "win") {
                    if (tm1.toInt() > tm2.toInt()) {
                        val diff = tm1.toInt() - tm2.toInt()
                        teamWon.text = "Team $tm1Name Won by $diff"
                    } else if (tm1.toInt() < tm2.toInt()) {
                        val diff = tm2.toInt() - tm1.toInt()
                        teamWon.text = "Team $tm2Name Won by $diff"
                    } else
                        teamWon.text = "match tied"
                }
                if (tm1Name == "IT")
                    imageView1.setImageResource(R.drawable.it)
                if (tm1Name == "MECH")
                    imageView1.setImageResource(R.drawable.mech)
                if (tm1Name == "CE")
                    imageView1.setImageResource(R.drawable.ce)
                if (tm1Name == "EE")
                    imageView1.setImageResource(R.drawable.ee)
                if (tm1Name == "EC")
                    imageView1.setImageResource(R.drawable.ec)
                if (tm1Name == "IC")
                    imageView1.setImageResource(R.drawable.ic)
                if (tm1Name == "CIVIL")
                    imageView1.setImageResource(R.drawable.civil)
                if (tm1Name == "ARCHI")
                    imageView1.setImageResource(R.drawable.archi)
                if (tm1Name == "AERO")
                    imageView1.setImageResource(R.drawable.aero)

                if (tm2Name == "IT")
                    imageView2.setImageResource(R.drawable.it)
                if (tm2Name == "MECH")
                    imageView2.setImageResource(R.drawable.mech)
                if (tm2Name == "CE")
                    imageView2.setImageResource(R.drawable.ce)
                if (tm2Name == "EE")
                    imageView2.setImageResource(R.drawable.ee)
                if (tm2Name == "EC")
                    imageView2.setImageResource(R.drawable.ec)
                if (tm2Name == "IC")
                    imageView2.setImageResource(R.drawable.ic)
                if (tm2Name == "CIVIL")
                    imageView2.setImageResource(R.drawable.civil)
                if (tm2Name == "ARCHI")
                    imageView2.setImageResource(R.drawable.archi)
                if (tm2Name == "AERO")
                    imageView2.setImageResource(R.drawable.aero)

            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }
        })

    }

}