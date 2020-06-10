package com.sparkbeta.spark

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class mode : AppCompatActivity() {
    var tm1Name = ""
    var tm2Name = ""
    var z = 0
    var y = 0
    private lateinit var run_1: Button
    private lateinit var run_0: Button
    private lateinit var run_2: Button
    private lateinit var run_3: Button
    private lateinit var run_4: Button
    private lateinit var run_5: Button
    private lateinit var run_6: Button
    private lateinit var score_store: Button
    private lateinit var clear_text: Button
    private lateinit var toss_info: EditText
    private lateinit var wide_btn: Button
    private lateinit var noball_btn: Button
    private lateinit var lb: Button
    private lateinit var updateLastBall: Button
    private lateinit var run_increase: Button
    private lateinit var run_decrease: Button
    private lateinit var ball_decrease: Button
    private lateinit var ball_increase: Button
    private lateinit var text_view: TextView
    private lateinit var wicket_plus: Button
    private lateinit var wicket_minus: Button
    private lateinit var tglBtn1: ToggleButton
    private lateinit var setPlrName: EditText
    private lateinit var setPlrBtn: Button
    private lateinit var disp_sc:Button
    private var win1_score:Int?=null
    private var wicket_count: Int? = null
    private var lastUpdateCount: Int = 0
    private var player1Run: Int = 0
    private var player2Run: Int = 0
    private var player1Name = ""
    private var player2Name = ""
    lateinit var user_view: TextView
    lateinit var total_zero: Button
    private var x = 0
    private var score = 0

    private lateinit var choose1: ImageView
    private lateinit var choose2: ImageView

    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode)

        val sw1 = findViewById<Switch>(R.id.switch1)

        val teamData=findViewById<Button>(R.id.teamData)

        teamData.setOnClickListener {
            startActivity(Intent(this@mode, team1data::class.java))
        }

        val spinner1 = findViewById<Spinner>(R.id.team1Spinner)
        val spinner2 = findViewById<Spinner>(R.id.team2Spinner)

        disp_sc=findViewById(R.id.disp_sc)
        clear_text=findViewById(R.id.clear_text)
        score_store = findViewById(R.id.score_store)
        wicket_plus = findViewById(R.id.wicket_plus)
        wicket_minus = findViewById(R.id.wicket_minus)
        total_zero = findViewById(R.id.count_zero)
        user_view = findViewById(R.id.user_view)

        run_0 = findViewById(R.id.run_0)
        run_1 = findViewById(R.id.run_1)
        run_2 = findViewById(R.id.run_2)
        run_3 = findViewById(R.id.run_3)
        run_4 = findViewById(R.id.run_4)
        run_5 = findViewById(R.id.run_5)
        run_6 = findViewById(R.id.run_6)

        wide_btn = findViewById(R.id.wide_btn)
        noball_btn = findViewById(R.id.noball_btn)
        lb = findViewById(R.id.lb)

        toss_info = findViewById(R.id.toss_info)

        updateLastBall = findViewById(R.id.updateLastBall)
        ball_decrease = findViewById(R.id.ball_minus)
        ball_increase = findViewById(R.id.ball_plus)
        text_view = findViewById(R.id.text_view)
        run_decrease = findViewById(R.id.run_minus)
        run_increase = findViewById(R.id.run_plus)

        tglBtn1 = findViewById(R.id.tglBtn1)
        setPlrBtn = findViewById(R.id.setPlrBtn)
        setPlrName = findViewById(R.id.setPlrName)

//        choose1 = findViewById(R.id.choose1)
//        choose2 = findViewById(R.id.choose2)

        var scoreStore1: Int
        var value = 0
        var ball = 0
        var ball_count = 0
        var wicket = 0

        val database1 = FirebaseDatabase.getInstance().getReference("cricket").child("lastUpdatedRun")
        val database = FirebaseDatabase.getInstance().getReference("cricket").child("finalScore")

        database1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                player1Run = dataSnapshot.child("Player-1").getValue(Int::class.java)!!
                player2Run = dataSnapshot.child("Player-2").getValue(Int::class.java)!!
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        val ef: DatabaseReference = database1.child("select")
        sw1?.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "0"
            else
                "1"
            ef.setValue(message)
        }

        val myRef: DatabaseReference = database.child("score")
        val KRef: DatabaseReference = database.child("score")
        val reff: DatabaseReference = database.child("ball")
        val yreff: DatabaseReference = database.child("wicket")
        val zreff: DatabaseReference = database.child("wide")
        val kreff: DatabaseReference = database.child("Noball")
        val toss: DatabaseReference = database.child("toss")
        val win_score: DatabaseReference = database.child("win_score")
        val need_score: DatabaseReference = database.child("need_score")
        val team1Name=database.child("team1Name")
        val team2Name=database.child("team2Name")

        database1.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                tglBtn1.textOff = dataSnapshot.child("player1Name").getValue(String::class.java)
                tglBtn1.textOn = dataSnapshot.child("player2Name").getValue(String::class.java)
            }
        })

        clear_text.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("Do you want to close this application ?")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                        dialog, id -> toss.setValue("")
                    win_score.setValue(0)
                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("CONFIRM")
            // show alert dialog
            alert.show()
        }

        var choose_count = 1

        total_zero.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("Do you want to set zero ?")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                        dialog, id -> team1Name.setValue("IT")
                    team2Name.setValue("IT")
                    tglBtn1.textOff = "Striker"
                    tglBtn1.textOn = "Non-striker"
                    score = 0
                    ball = 0
                    wicket = 0
                    player1Run = 0
                    player2Run = 0
                    lastUpdateCount = 0
                    text_view.text = text_view.hint
                    user_view.text = user_view.hint
                    reff.setValue(ball)
                    myRef.setValue(score)
                    yreff.setValue(wicket)
                    database1.child("Player-1").setValue(0)
                    database1.child("Player-2").setValue(0)
                    database1.child("extraCount").setValue(0)
                    database1.child("lastUpdatedCount").setValue(0)
                    database1.child("player1Name").setValue("---")
                    database1.child("player2Name").setValue("---")
                    database1.child("0").setValue("0")
                    database1.child("1").setValue("0")
                    database1.child("2").setValue("0")
                    database1.child("3").setValue("0")
                    database1.child("4").setValue("0")
                    database1.child("5").setValue("0")
                    database1.child("6").setValue("0")
                    database1.child("7").setValue("0")
                    database1.child("8").setValue("0")
                    database1.child("9").setValue("0")
                    database1.child("10").setValue("0")
                    toss.setValue(toss_info.text.toString())
                    need_score.setValue(0)
                    Toast.makeText(applicationContext, "All set", Toast.LENGTH_SHORT).show()
                   //Log.d("Instance ID", FirebaseInstanceId.getInstance().getId())
                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("CONFIRM")
            // show alert dialog
            alert.show()
        }

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                tm1Name = dataSnapshot.child("team1Name").getValue(String::class.java).toString()
                tm2Name = dataSnapshot.child("team2Name").getValue(String::class.java).toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

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

        val teams = resources.getStringArray(R.array.Team)

        if (spinner1 != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, teams)
            spinner1.adapter = adapter
            var x = 0


            database.addValueEventListener(object : ValueEventListener {
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
                    database.child("team1Name").setValue(teams[position])
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

            database.addValueEventListener(object : ValueEventListener {
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
                    database.child("team2Name").setValue(teams[position])
                    y = 1
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
        }

        score_store.setOnClickListener {
            scoreStore1 = value+1
            win_score.setValue(scoreStore1)
        }

        run_0.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                tglBtn1.isChecked = !tglBtn1.isChecked
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1
            val score1: Int? = value.plus(0)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run += 0
                else
                    player1Run += 0
            } else x = 0

            database1.child("Player-2").setValue(player2Run)
            database1.child("Player-1").setValue(player1Run)
            database1.child(lastUpdateCount.toString()).setValue("0")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            val ball1: Int? = ball_count.plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "0"

            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score1"
            user_view.text = f
        }

        run_1.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                tglBtn1.isChecked = !tglBtn1.isChecked
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1
            val score1: Int? = value.plus(1)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run += 1
                else
                    player1Run += 1
            } else x = 0

            database1.child("Player-2").setValue(player2Run)
            database1.child("Player-1").setValue(player1Run)
            tglBtn1.isChecked = !tglBtn1.isChecked
            database1.child(lastUpdateCount.toString()).setValue("1")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()

            val ball1: Int? = ball_count.plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "1"

            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score1"
            user_view.text = f
        }

        run_2.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                tglBtn1.isChecked = !tglBtn1.isChecked
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1

            val score1: Int? = value.plus(2)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run += 2
                else
                    player1Run += 2
            } else x = 0

            database1.child("Player-2").setValue(player2Run)
            database1.child("Player-1").setValue(player1Run)
            database1.child(lastUpdateCount.toString()).setValue("2")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()

            val ball1: Int? = ball_count.plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "2"

            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score1"
            user_view.text = f
        }

        run_3.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                tglBtn1.isChecked = !tglBtn1.isChecked
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1
            val score1: Int? = value.plus(3)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run += 3
                else
                    player1Run += 3
            } else x = 0

            database1.child("Player-2").setValue(player2Run)
            database1.child("Player-1").setValue(player1Run)
            tglBtn1.isChecked = !tglBtn1.isChecked
            database1.child(lastUpdateCount.toString()).setValue("3")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()

            val ball1: Int? = ball_count.plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "3"

            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score1"
            user_view.text = f
        }

        run_4.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                tglBtn1.isChecked = !tglBtn1.isChecked
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1
            val score1: Int? = value.plus(4)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run += 4
                else
                    player1Run += 4
            } else x = 0

            database1.child("Player-2").setValue(player2Run)
            database1.child("Player-1").setValue(player1Run)
            database1.child(lastUpdateCount.toString()).setValue("4")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()

            val ball1: Int? = ball_count.plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "4"

            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score1"
            user_view.text = f
        }
        run_5.setOnClickListener {

            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                tglBtn1.isChecked = !tglBtn1.isChecked
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1
            val score1: Int? = value.plus(5)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run += 5
                else
                    player1Run += 5
            } else x = 0

            database1.child("Player-2").setValue(player2Run)
            database1.child("Player-1").setValue(player1Run)
            database1.child(lastUpdateCount.toString()).setValue("5")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()

            val ball1: Int? = ball_count.plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "5"

            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score1"
            user_view.text = f
        }

        run_6.setOnClickListener {

            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                tglBtn1.isChecked = !tglBtn1.isChecked
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1

            val score1: Int? = value.plus(6)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run += 6
                else
                    player1Run += 6
            } else x = 0

            database1.child("Player-2").setValue(player2Run)
            database1.child("Player-1").setValue(player1Run)
            database1.child(lastUpdateCount.toString()).setValue("6")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()

            val ball1: Int? = ball_count.plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "6"

            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score1"
            user_view.text = f
        }

        run_increase.setOnClickListener {
            val score1: Int? = value.plus(1)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run += 1
                else
                    player1Run += 1
            } else x = 0
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "Run +1"

            val x = ball_count.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score1"
            user_view.text = f
        }

        run_decrease.setOnClickListener {

            val score1: Int? = value.minus(1)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run -= 1
                else
                    player1Run -= 1
            } else x = 0

            database1.child("Player-1").setValue(player1Run)
            database1.child("Player-2").setValue(player2Run)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "Run -1"

            val x = ball_count.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score1"
            user_view.text = f
        }

        ball_increase.setOnClickListener {

            val ball1: Int? = ball_count.plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "ball +1"

            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$value"
            user_view.text = f
        }

        ball_decrease.setOnClickListener {

            val ball1: Int? = ball_count.minus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "ball -1"

            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$value"
            user_view.text = f
        }

        wicket_minus.setOnClickListener {

            val wk: Int? = wicket_count?.minus(1)
            yreff.setValue(wk)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "Wicket -1"
        }

        wicket_plus.setOnClickListener {

            val wk: Int? = wicket_count?.plus(1)
            yreff.setValue(wk)

            if (ball_count % 6 == 0)
                lastUpdateCount = 0
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1

            database1.child(lastUpdateCount.toString()).setValue("wk")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)

            val ball1: Int? = ball_count.plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "Wicket +1"
        }

        wide_btn.setOnClickListener {

            val score1: Int? = value.plus(1)
            myRef.setValue(score1)

            if (ball_count % 6 == 0)
                lastUpdateCount = 0
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1

            database1.child(lastUpdateCount.toString()).setValue("wd")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "Wide button"
            zreff.setValue("1")

            val x = ball_count.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score1"
            user_view.text = f
        }

        noball_btn.setOnClickListener {

            val score1: Int? = value.plus(1)
            myRef.setValue(score1)

            if (ball_count % 6 == 0)
                lastUpdateCount = 0
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1

            database1.child(lastUpdateCount.toString()).setValue("nb")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT).show()
            text_view.text = "No ball"
            kreff.setValue("1")

            val x = ball_count.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score1"
            user_view.text = f
        }

        lb.setOnClickListener {

            x = 1
            if (ball_count % 6 == 0)
                lastUpdateCount = 0
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1

            database1.child(lastUpdateCount.toString()).setValue("lb")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)

            val ball1: Int? = ball_count.plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "lb"

            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            val f = "$z,$score"
            user_view.text = f
        }
        val current_p1=database1.child("Current_player")

        setPlrBtn.setOnClickListener {

            if (tglBtn1.isChecked) {
                player2Name = setPlrName.text.toString()
                database1.child("player2Name").setValue(player2Name)
                player2Run = 0
                tglBtn1.textOn = player2Name
                database1.child("Player-2").setValue(0)
            } else {
                player1Name = setPlrName.text.toString()
                database1.child("player1Name").setValue(player1Name)
                player1Run = 0
                tglBtn1.textOff = player1Name
                database1.child("Player-1").setValue(0)
            }

//          setPlrName.text = setPlrName.hint as Editable?
            Toast.makeText(applicationContext, "Name Updated", Toast.LENGTH_SHORT)
                .show()

        }

        updateLastBall.setOnClickListener {
            lastUpdateCount -= 1

        }

        tglBtn1.setOnCheckedChangeListener { buttonView, isChecked ->
            setPlrName.text = Editable.Factory.getInstance().newEditable("")
            val msg = "Toggle Button is " + if (isChecked) "ON" else "OFF"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            if(tglBtn1.isChecked){
                current_p1.setValue("0")
            }
            else{
                current_p1.setValue("1")
            }

        }

        win_score.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                win1_score = dataSnapshot.getValue(Int::class.java)!!.toString().toInt()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No value", Toast.LENGTH_SHORT).show()
            }
        })

        disp_sc.setOnClickListener {

            KRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    value = dataSnapshot.getValue(Int::class.java)!!.toString().toInt()
                    val s= win1_score?.minus(value)
                    need_score.setValue(s)

                }

                override fun onCancelled(error: DatabaseError) { // Failed to read value
                    Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}

