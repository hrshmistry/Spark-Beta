package com.example.spark

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_kabaddi_bd.*

class kabaddi_bd : AppCompatActivity() {
    private lateinit var plus1: Button
    private lateinit var minus1: Button
    private lateinit var plus2: Button
    private lateinit var minus2: Button
    private lateinit var setToZero: Button
    private lateinit var win: Button

    var score1 = 0
    var score2 = 0
    var temp = "0"
    var tm1 = "0"
    var tm2 = "0"
    var tm1Name = ""
    var tm2Name = ""
    var z = 0
    var y = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kabaddi_bd)
        val spinner1 = findViewById<Spinner>(R.id.team1Spinner)
        val spinner2 = findViewById<Spinner>(R.id.team2Spinner)

        plus1 = findViewById(R.id.plus1)
        minus1 = findViewById(R.id.minus1)
        plus2 = findViewById(R.id.plus2)
        minus2 = findViewById(R.id.minus2)
        setToZero = findViewById(R.id.setToZero)
        win = findViewById(R.id.win)

        val rf = FirebaseDatabase.getInstance().getReference("Kabaddi")
        rf.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(ds: DataSnapshot) {
                tm1 = ds.child("team1Score").getValue(Int::class.java).toString()
                tm2 = ds.child("team2Score").getValue(Int::class.java).toString()
                tm1Name = ds.child("team1Name").getValue(String::class.java).toString()
                tm2Name = ds.child("team2Name").getValue(String::class.java).toString()


                if (tm1 == "null")
                    tm1 = "0"
                if (tm2 == "null")
                    tm2 = "0"
                score2 = tm2.toInt()
                score1 = tm1.toInt()
                temp = "$tm1 - $tm2"
                modScore.text = temp
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }
        })

        val teams = resources.getStringArray(R.array.Team)

        if (spinner1 != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, teams)
            spinner1.adapter = adapter
            var x = 0


            rf.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(ds: DataSnapshot) {
                    tm1Name = ds.child("team1Name").getValue(String::class.java).toString()

                    if (tm1Name == "null")
                        tm1Name = "IT"
                    x = adapter.getPosition(tm1Name)
                }

                override fun onCancelled(p0: DatabaseError) {
                    Log.d("Exception", p0.message)
                }
            })


            spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    Int: Long
                ) {
                    if (z == 0) {
                        spinner1.setSelection(x)
                    }
                    rf.child("team1Name").setValue(teams[position])
                    z = 1
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
        }
        if (spinner2 != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, teams)
            spinner2.adapter = adapter
            var x = 0


            rf.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(ds: DataSnapshot) {
                    tm2Name = ds.child("team2Name").getValue(String::class.java).toString()

                    if (tm2Name == "null")
                        tm2Name = "IT"

                    x = adapter.getPosition(tm2Name)
                }

                override fun onCancelled(p0: DatabaseError) {
                    Log.d("Exception", p0.message)
                }
            })
            spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    Int: Long
                ) {

                    if (y == 0) {
                        spinner2.setSelection(x)
                    }
                    rf.child("team2Name").setValue(teams[position])
                    y = 1
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
        }
        plus1.setOnClickListener {
            score1 += 1
            rf.child("team1Score").setValue(score1)
        }

        minus1.setOnClickListener {
            score1 -= 1
            rf.child("team1Score").setValue(score1)
        }
        plus2.setOnClickListener {
            score2 += 1
            rf.child("team2Score").setValue(score2)
        }

        minus2.setOnClickListener {
            score2 -= 1
            rf.child("team2Score").setValue(score2)
        }

        setToZero.setOnClickListener {
            score1 = 0
            score2 = 0

            rf.child("team1Score").setValue(score1)
            rf.child("team2Score").setValue(score2)
            rf.child("win").setValue("")
        }
        win.setOnClickListener {

            rf.child("win").setValue("win")
        }
    }
}