package com.example.spark

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class view : AppCompatActivity() {
    private val TAG = "MyFirebaseToken"
    private var Edit_text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        Edit_text = findViewById(R.id.textView)
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        val bundle: Bundle? = intent.extras
        val text = bundle?.get("text").toString()
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value =
                    dataSnapshot.getValue(Int::class.java)!!.toString()
                //Toast.makeText(applicationContext, value, Toast.LENGTH_SHORT).show()
                Edit_text?.text = value
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
