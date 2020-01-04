package com.example.spark

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_football_bd.*

class football_bd : AppCompatActivity() {


    private lateinit var t: TextView
    private lateinit var t1: TextView
    var y = ""
    var y1 = ""

    private lateinit var a: TextView
    private lateinit var b: Button
    private lateinit var c: Button
    var d = 0

    private lateinit var a1: TextView
    private lateinit var b1: Button
    private lateinit var c1: Button
    var d1 = 0

    val database = FirebaseDatabase.getInstance()
    val pat = database.getReference("Team 1")
    val el = database.getReference("Team 2")
    val myref = database.getReference("Soccer")
    val myshi = database.getReference("Soccer2")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football_bd)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val team = resources.getStringArray(R.array.Team)
        val name = findViewById<TextView>(R.id.teamName)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, team)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    Int: Long
                ) {
                    teamName.text = team[position]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
        }

        t = findViewById(R.id.editText3)
        t1 = findViewById(R.id.editText4)

        a = findViewById(R.id.editText)
        b = findViewById(R.id.button)
        c = findViewById(R.id.button2)

        a1 = findViewById(R.id.editText2)
        b1 = findViewById(R.id.button3)
        c1 = findViewById(R.id.button4)

        myref.setValue(0)

        t.setOnClickListener {
            y = t.text.toString()
            pat.setValue(y)
        }


        t1.setOnClickListener {
            y1 = t1.text.toString()
            el.setValue(y1)
        }

        b.setOnClickListener {
            d++
            a.text = d.toString()
            myref.setValue(d)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
        }

        c.setOnClickListener {
            d--
            myref.setValue(d)
            a.text = d.toString()
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
        }

        myshi.setValue(0)

        b1.setOnClickListener {
            d1++
            myshi.setValue(d1)
            a1.text = d1.toString()
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
        }

        c1.setOnClickListener {
            d1--
            myshi.setValue(d1)
            a1.text = d1.toString()
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
        }
    }

}
