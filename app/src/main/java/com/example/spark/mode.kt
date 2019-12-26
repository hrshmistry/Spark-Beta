package com.example.spark

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class mode : AppCompatActivity() {
    private lateinit var run_1: Button
    private lateinit var run_2: Button
    private lateinit var run_3: Button
    private lateinit var run_4: Button
    private lateinit var run_5: Button
    private lateinit var run_6: Button
    private lateinit var wide_btn: Button
    private lateinit var noball_btn: Button
    private lateinit var run_increase: Button
    private lateinit var run_decrease: Button
    private lateinit var ball_decrease: Button
    private lateinit var ball_increase: Button
    private lateinit var text_view: TextView
    private lateinit var wicket_plus: Button
    private lateinit var wicket_minus: Button
    private var value: Int? = null
    private var wicket_count: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode)
        wicket_plus = findViewById(R.id.wicket_plus)
        wicket_minus = findViewById(R.id.wicket_minus)
        run_1 = findViewById(R.id.run_1)
        run_2 = findViewById(R.id.run_2)
        run_3 = findViewById(R.id.run_3)
        run_4 = findViewById(R.id.run_4)
        run_5 = findViewById(R.id.run_5)
        run_6 = findViewById(R.id.run_6)
        wide_btn = findViewById(R.id.wide_btn)
        noball_btn = findViewById(R.id.noball_btn)
        ball_decrease = findViewById(R.id.ball_decrease)
        ball_increase = findViewById(R.id.ball_increase)
        text_view = findViewById(R.id.text_view)
        run_decrease = findViewById(R.id.run_decrease)
        run_increase = findViewById(R.id.run_increase)
        var score: Int = 0
        var ball = 0
        var ball_count = 0
        var wicket = 0
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("score")
        val reff = database.getReference("ball")
        val yreff = database.getReference("wicket")
        val zreff = database.getReference("wide")
        val kreff = database.getReference("Noball")
        reff.setValue(ball)
        myRef.setValue(score)
        yreff.setValue(wicket)
        reff.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                ball_count = dataSnapshot.getValue(Int::class.java)!!.toString().toInt()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                value = dataSnapshot.getValue(Int::class.java)!!.toString().toInt()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })
        yreff.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                wicket_count = dataSnapshot.getValue(Int::class.java)!!.toString().toInt()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })
        run_1.setOnClickListener {
            var score1: Int? = value?.toInt()?.plus(1)
            myRef.setValue(score1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            var ball: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "1"
        }
        run_2.setOnClickListener {
            var score1: Int? = value?.toInt()?.plus(2)
            myRef.setValue(score1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            var ball: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "2"
        }
        run_3.setOnClickListener {
            var score1: Int? = value?.toInt()?.plus(3)
            myRef.setValue(score1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            var ball: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "3"
        }
        run_4.setOnClickListener {
            var score1: Int? = value?.toInt()?.plus(4)
            myRef.setValue(score1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            var ball: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "4"
        }
        run_5.setOnClickListener {
            var score1: Int? = value?.toInt()?.plus(5)
            myRef.setValue(score1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            var ball: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "5"
        }
        run_6.setOnClickListener {
            var score1: Int? = value?.toInt()?.plus(6)
            myRef.setValue(score1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            var ball: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "6"
        }
        run_increase.setOnClickListener {
            var score1: Int? = value?.toInt()?.plus(1)
            myRef.setValue(score1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "Run +1"
        }
        run_decrease.setOnClickListener {
            var score1: Int? = value?.toInt()?.minus(1)
            myRef.setValue(score1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "Run -1"
        }
        ball_increase.setOnClickListener {
            var ball: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "ball +1"
        }
        ball_decrease.setOnClickListener {
            var ball: Int? = ball_count.toInt().minus(1)
            reff.setValue(ball)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "ball -1"
        }
        wicket_minus.setOnClickListener {
            var wc: Int? = wicket_count?.toInt()!!.minus(1)
            yreff.setValue(wc)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "Wicket -1"
        }
        wicket_plus.setOnClickListener {
            var wc: Int? = wicket_count?.toInt()!!.plus(1)
            yreff.setValue(wc)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "Wicket +1"
        }
        wide_btn.setOnClickListener {
            var score1: Int? = value?.toInt()?.plus(1)
            myRef.setValue(score1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "Wide button"
            zreff.setValue("1")
        }
        noball_btn.setOnClickListener {
            var score1: Int? = value?.toInt()?.plus(1)
            myRef.setValue(score1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "No ball"
            kreff.setValue("1")
        }
    }
}