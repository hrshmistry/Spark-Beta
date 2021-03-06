package com.sparkbeta.spark

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.google.firebase.database.FirebaseDatabase

class badminton_bd : AppCompatActivity() {

    lateinit var play1: EditText
    lateinit var play2: EditText
    lateinit var play3: EditText
    lateinit var play4: EditText
    lateinit var play5: EditText
    lateinit var play6: EditText
    lateinit var play7: EditText
    lateinit var play8: EditText

    lateinit var dd1: EditText
    lateinit var dd2: EditText
    lateinit var dd3: EditText
    lateinit var dd4: EditText
    lateinit var dd5: EditText
    lateinit var dd6: EditText
    lateinit var dd7: EditText
    lateinit var dd8: EditText

    lateinit var buttonSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Animatoo.animateFade(this)
        setContentView(R.layout.activity_badminton_bd)

        play1 = findViewById(R.id.single_bp71)
        play2 = findViewById(R.id.single_bp2)
        play3 = findViewById(R.id.play3)
        play4 = findViewById(R.id.play4)
        play5 = findViewById(R.id.play5)
        play6 = findViewById(R.id.play6)
        play7 = findViewById(R.id.play7)
        play8 = findViewById(R.id.play8)

        dd1 = findViewById(R.id.dbps1)
        dd2 = findViewById(R.id.dbps2)
        dd3 = findViewById(R.id.dbdp1)
        dd4 = findViewById(R.id.dbdp2)
        dd5 = findViewById(R.id.dgsp1)
        dd6 = findViewById(R.id.dgsp2)
        dd7 = findViewById(R.id.dgdp1)
        dd8 = findViewById(R.id.dbps2)

        buttonSave = findViewById(R.id.buttonSave)

        buttonSave.setOnClickListener {
            submitData()
        }
    }

    private fun submitData() {
        val name1 = play1.text.toString().trim()
        val name2 = play2.text.toString().trim()
        val name3 = play3.text.toString().trim()
        val name4 = play4.text.toString().trim()
        val name5 = play5.text.toString().trim()
        val name6 = play6.text.toString().trim()
        val name7 = play7.text.toString().trim()
        val name8 = play8.text.toString().trim()
        val d1 = dd1.text.toString().trim()
        val d2 = dd2.text.toString().trim()
        val d3 = dd3.text.toString().trim()
        val d4 = dd4.text.toString().trim()
        val d5 = dd5.text.toString().trim()
        val d6 = dd6.text.toString().trim()
        val d7 = dd7.text.toString().trim()
        val d8 = dd8.text.toString().trim()

        if (name1.isEmpty() || name2.isEmpty() || name3.isEmpty()
            || name4.isEmpty() || name5.isEmpty() || name6.isEmpty()
            || name7.isEmpty() || name8.isEmpty()
        ) {
            play1.error = "Please enter name"
            play2.error = "Please enter name"
            play3.error = "Please enter name"
            play4.error = "Please enter name"
            play5.error = "Please enter name"
            play6.error = "Please enter name"
            play7.error = "Please enter name"
            play8.error = "Please enter name"
            return
        }

        if (d1.isEmpty() || d2.isEmpty() || d3.isEmpty()
            || d4.isEmpty() || d5.isEmpty() || d6.isEmpty()
            || d7.isEmpty() || d8.isEmpty()
        ) {
            dd1.error = "Please enter name"
            dd2.error = "Please enter name"
            dd3.error = "Please enter name"
            dd4.error = "Please enter name"
            dd5.error = "Please enter name"
            dd6.error = "Please enter name"
            dd7.error = "Please enter name"
            dd8.error = "Please enter name"
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("Players")
        val player1 = SaveData(d1, name1)
        val player2 = SaveData(d2, name2)
        val player3 = SaveData(d3, name3)
        val player4 = SaveData(d4, name4)
        val player5 = SaveData(d5, name5)
        val player6 = SaveData(d6, name6)
        val player7 = SaveData(d7, name7)
        val player8 = SaveData(d8, name8)

        ref.child("1").setValue(player1).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Submitted Successfully", Toast.LENGTH_LONG)
                .show()
        }
        //     ref.child("1").child("dept")
        ref.child("2").setValue(player2).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Submitted Successfully", Toast.LENGTH_LONG)
                .show()
        }
        ref.child("3").setValue(player3).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Submitted Successfully", Toast.LENGTH_LONG)
                .show()
        }
        ref.child("4").setValue(player4).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Submitted Successfully", Toast.LENGTH_LONG)
                .show()
        }
        ref.child("5").setValue(player5).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Submitted Successfully", Toast.LENGTH_LONG)
                .show()
        }
        ref.child("6").setValue(player6).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Submitted Successfully", Toast.LENGTH_LONG)
                .show()
        }
        ref.child("7").setValue(player7).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Submitted Successfully", Toast.LENGTH_LONG)
                .show()
        }
        ref.child("8").setValue(player8).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Submitted Successfully", Toast.LENGTH_LONG)
                .show()
        }
    }
}
