package com.sparkbeta.spark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.google.firebase.database.*

class team1 : AppCompatActivity() {
    private var playerName1:String?=null
    private var playerName2:String?=null
    lateinit var play1: EditText
    lateinit var play2: EditText
    lateinit var play3: EditText
    lateinit var play4: EditText
    lateinit var play5: EditText
    lateinit var play6: EditText
    lateinit var play7: EditText
    lateinit var play8: EditText
    lateinit var play9: EditText
    lateinit var play10: EditText
    lateinit var play11: EditText
    lateinit var r1: TextView
    lateinit var r2: TextView
    lateinit var r3: TextView
    lateinit var r4: TextView
    lateinit var r5: TextView
    lateinit var r6: TextView
    lateinit var r7: TextView
    lateinit var r8: TextView
    lateinit var r9: TextView
    lateinit var r10: TextView
    lateinit var r11: TextView
    lateinit var buttonSave: Button
    private var run1:Int?=null
    private var run2:Int?=null
    private var nameA:TextView?=null
    lateinit var select1:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Animatoo.animateFade(this)
        setContentView(R.layout.activity_team1)

        nameA=findViewById(R.id.team_name)

        play1 = findViewById(R.id.play1)
        play2 = findViewById(R.id.play2)
        play3 = findViewById(R.id.play3)
        play4 = findViewById(R.id.play4)
        play5 = findViewById(R.id.play5)
        play6 = findViewById(R.id.play6)
        play7 = findViewById(R.id.play7)
        play8 = findViewById(R.id.play8)
        play9 = findViewById(R.id.play9)
        play10 = findViewById(R.id.play10)
        play11 = findViewById(R.id.play11)

        r1=findViewById(R.id.r1)
        r2=findViewById(R.id.r2)
        r3=findViewById(R.id.r3)
        r4=findViewById(R.id.r4)
        r5=findViewById(R.id.r5)
        r6=findViewById(R.id.r6)
        r7=findViewById(R.id.r7)
        r8=findViewById(R.id.r8)
        r9=findViewById(R.id.r9)
        r10=findViewById(R.id.r10)
        r11=findViewById(R.id.r11)

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
        val name9 = play9.text.toString().trim()
        val name10 = play10.text.toString().trim()
        val name11 = play11.text.toString().trim()

        val ru1 = "---"
        val ru2 = "---"
        val ru3 = "---"
        val ru4 = "---"
        val ru5 = "---"
        val ru6 = "---"
        val ru7 = "---"
        val ru8 = "---"
        val ru9 = "---"
        val ru10 = "---"
        val ru11 = "---"

        if (name1.isEmpty() || name2.isEmpty() || name3.isEmpty()
            || name4.isEmpty() || name5.isEmpty() || name6.isEmpty()
            || name7.isEmpty() || name8.isEmpty() || name9.isEmpty() || name10.isEmpty() || name11.isEmpty()
        ) {
            play1.error = "Please enter name"
            play2.error = "Please enter name"
            play3.error = "Please enter name"
            play4.error = "Please enter name"
            play5.error = "Please enter name"
            play6.error = "Please enter name"
            play7.error = "Please enter name"
            play8.error = "Please enter name"
            play9.error = "Please enter name"
            play10.error = "Please enter name"
            play11.error = "Please enter name"
            return
        }

        val database1: FirebaseDatabase = FirebaseDatabase.getInstance()
        val myref: DatabaseReference = database1.getReference("cricket").child("lastUpdatedRun")
        val p1name: DatabaseReference = myref.child("player1Name")
        val p2name: DatabaseReference = myref.child("player2Name")
        val ref = FirebaseDatabase.getInstance().getReference("cricket").child("Team A")

        val player1 = SaveData5(name1, ru1)
        val player2 = SaveData5(name2, ru2)
        val player3 = SaveData5(name3, ru3)
        val player4 = SaveData5(name4, ru4)
        val player5 = SaveData5(name5, ru5)
        val player6 = SaveData5(name6, ru6)
        val player7 = SaveData5(name7, ru7)
        val player8 = SaveData5(name8, ru8)
        val player9 = SaveData5(name9, ru9)
        val player10 = SaveData5(name10, ru10)
        val player11 = SaveData5(name11, ru11)

        val database2 =
            FirebaseDatabase.getInstance().getReference("cricket").child("lastUpdatedRun")
        val run11: DatabaseReference = database2.child("Player-1")
        val run12: DatabaseReference = database2.child("Player-2")

        val select: DatabaseReference = database2.child("select")

        p1name.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                playerName1 = dataSnapshot.getValue(String::class.java)!!
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p2name.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                playerName2 = dataSnapshot.getValue(String::class.java)!!
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })
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
        ref.child("9").setValue(player9).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Submitted Successfully", Toast.LENGTH_LONG)
                .show()
        }
        ref.child("10").setValue(player10).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Submitted Successfully", Toast.LENGTH_LONG)
                .show()
        }
        ref.child("11").setValue(player11).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Submitted Successfully", Toast.LENGTH_LONG)
                .show()
        }

        select.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                select1 = dataSnapshot.getValue(String::class.java)!!
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        run11.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                run1 = dataSnapshot.getValue(Int::class.java)!!
                if (select1 == "0") {
                    when (playerName1) {
                        name1 -> {
                            ref.child("1").child("run").setValue(run1.toString())
                        }
                        name2 -> {
                            ref.child("2").child("run").setValue(run1.toString())
                        }
                        name3 -> {
                            ref.child("3").child("run").setValue(run1.toString())
                        }
                        name4 -> {
                            ref.child("4").child("run").setValue(run1.toString())
                        }
                        name5 -> {
                            ref.child("5").child("run").setValue(run1.toString())
                        }
                        name6 -> {
                            ref.child("6").child("run").setValue(run1.toString())
                        }
                        name7 -> {
                            ref.child("7").child("run").setValue(run1.toString())
                        }
                        name8 -> {
                            ref.child("8").child("run").setValue(run1.toString())
                        }
                        name9 -> {
                            ref.child("9").child("run").setValue(run1.toString())
                        }
                        name10 -> {
                            ref.child("10").child("run").setValue(run1.toString())
                        }
                        name11 -> {
                            ref.child("11").child("run").setValue(run1.toString())
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        run12.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                run2 = dataSnapshot.getValue(Int::class.java)!!
                if (select1 == "0") {
                    when (playerName2) {
                        name1 -> {
                            ref.child("1").child("run").setValue(run2.toString())
                        }
                        name2 -> {
                            ref.child("2").child("run").setValue(run2.toString())
                        }
                        name3 -> {
                            ref.child("3").child("run").setValue(run2.toString())
                        }
                        name4 -> {
                            ref.child("4").child("run").setValue(run2.toString())
                        }
                        name5 -> {
                            ref.child("5").child("run").setValue(run2.toString())
                        }
                        name6 -> {
                            ref.child("6").child("run").setValue(run2.toString())
                        }
                        name7 -> {
                            ref.child("7").child("run").setValue(run2.toString())
                        }
                        name8 -> {
                            ref.child("8").child("run").setValue(run2.toString())
                        }
                        name9 -> {
                            ref.child("9").child("run").setValue(run2.toString())
                        }
                        name10 -> {
                            ref.child("10").child("run").setValue(run2.toString())
                        }
                        name11 -> {
                            ref.child("11").child("run").setValue(run2.toString())
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })
    }
}