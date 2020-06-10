package com.sparkbeta.spark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.google.firebase.database.*

class team1data : AppCompatActivity() {

    private lateinit var teamA:Button
    private lateinit var teamB:Button
    private lateinit var nameA:EditText
    private lateinit var nameB:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Animatoo.animateCard(this)
        setContentView(R.layout.activity_team1data)
        teamA=findViewById(R.id.teamA)
        teamB=findViewById(R.id.teamB)
        nameA=findViewById(R.id.TeamA)
        nameB=findViewById(R.id.TeamB)

        val database1: FirebaseDatabase = FirebaseDatabase.getInstance()
        val Aref: DatabaseReference = database1.getReference("cricket").child("Team A").child("NameA")
        val Bref: DatabaseReference = database1.getReference("cricket").child("Team B").child("NameB")

        teamA.setOnClickListener {
            var intent = Intent(this@team1data, team1::class.java)
            startActivity(intent)
            Aref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    Aref.setValue(nameA.text.toString())
                }

                override fun onCancelled(error: DatabaseError) { // Failed to read value
                    Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
                }
            })
        }
        teamB.setOnClickListener {
            var intent = Intent(this@team1data, team2::class.java)
            startActivity(intent)
            Bref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    Bref.setValue(nameB.text.toString())
                }

                override fun onCancelled(error: DatabaseError) { // Failed to read value
                    Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
