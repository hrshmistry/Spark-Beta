package com.example.spark

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class football : AppCompatActivity() {

    private lateinit var tm1: TextView
    private lateinit var tm2: TextView
    private lateinit var scr1: TextView
    private lateinit var scr2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football)

        tm1 = findViewById(R.id.editText5)
        tm2 = findViewById(R.id.editText6)
        scr1 = findViewById(R.id.editText7)
        scr2 = findViewById(R.id.editText8)
        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("Team 1")
        val reference2 = database.getReference("Team 2")
        val reference3 = database.getReference("Soccer")
        val reference4 = database.getReference("Soccer2")

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                // for(ds in dataSnapshot.children){
                tm1.text = dataSnapshot.getValue(String::class.java)

            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }


        })
        reference2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                // for(ds in dataSnapshot.children){
                tm2.text = dataSnapshot.getValue(String::class.java)

            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }


        })
        reference3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                // for(ds in dataSnapshot.children){
                scr1.text = dataSnapshot.getValue(Int::class.java).toString()

            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }


        })
        reference4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                // for(ds in dataSnapshot.children){
                scr2.text = dataSnapshot.getValue(Int::class.java).toString()

            }

            override fun onCancelled(p0: DatabaseError) {
                Log.d("Exception", p0.message)
            }


        })
    }
}