package com.example.spark

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class mode : AppCompatActivity() {
    private lateinit var run_1: Button
    private lateinit var run_0: Button
    private lateinit var run_2: Button
    private lateinit var run_3: Button
    private lateinit var run_4: Button
    private lateinit var run_5: Button
    private lateinit var run_6: Button
    private lateinit var teamA: Button
    private lateinit var teamB: Button
    private lateinit var score_store: Button
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
    private var wicket_count: Int? = null
    private var lastUpdateCount: Int = 0
    private var player1Run: Int = 0
    private var player2Run: Int = 0
    private var player1Name = ""
    private var player2Name = ""
    lateinit var user_view: TextView
    lateinit var total_zero: Button
    private lateinit var player_details: Button
    private var x = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode)
        //player_details=findViewById(R.id.player_details)
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
        toss_info = findViewById(R.id.toss_info)
        lb = findViewById(R.id.lb)
        updateLastBall = findViewById(R.id.updateLastBall)
        ball_decrease = findViewById(R.id.ball_minus)
        ball_increase = findViewById(R.id.ball_plus)
        text_view = findViewById(R.id.text_view)
        run_decrease = findViewById(R.id.run_minus)
        run_increase = findViewById(R.id.run_plus)
        tglBtn1 = findViewById(R.id.tglBtn1)
        setPlrBtn = findViewById(R.id.setPlrBtn)
        setPlrName = findViewById(R.id.setPlrName)
        //  player_details = findViewById(R.id.player_details)
        var scoreStore1: Int
        var value: Int = 0
        var score: Int = 0
        var ball = 0

        var ball_count = 0
        var wicket = 0
        var database = FirebaseDatabase.getInstance().getReference("cricket").child("finalScore")
        var database2 = FirebaseDatabase.getInstance().getReference("score_store")
        var myRef: DatabaseReference = database.child("score")
        var reff: DatabaseReference = database.child("ball")
        var yreff: DatabaseReference = database.child("wicket")
        var zreff: DatabaseReference = database.child("wide")
        var kreff: DatabaseReference = database.child("Noball")
        var toss: DatabaseReference = database.child("toss")
        var win_score: DatabaseReference = database.child("win_score")
        //myRef.setValue(0)
        //reff.setValue(0)
        win_score.setValue(0)
        var toss1 = "Yet to decide"
        var database1 =
            FirebaseDatabase.getInstance().getReference("cricket").child("lastUpdatedRun")
        var ref1: DatabaseReference = database1.child("Player-1")
        var ref2: DatabaseReference = database1.child("Player-1")

        total_zero.setOnClickListener {
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
            toss1 = toss_info.text.toString()
            toss.setValue(toss1)
            Toast.makeText(applicationContext, "All Set", Toast.LENGTH_SHORT).show()
        }

//        database1.addValueEventListener(object: ValueEventListener {
//
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                if (tglBtn1.isChecked)
//                    tglBtn1.textOn = dataSnapshot.child("player2Name").getValue(String::class.java).toString()
//                else
//                    tglBtn1.textOff = dataSnapshot.child("player1Name").getValue(String::class.java).toString()
//            }
//
//            override fun onCancelled(p0: DatabaseError) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//        })

        /*player_details.setOnClickListener {
            val intent = Intent(this@mode, teamdata::class.java)
            startActivity(intent)
        }*/

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

        score_store.setOnClickListener {
            toss.setValue("")
            scoreStore1 = value
            win_score.setValue(scoreStore1)
            toss.setValue("")
        }

        run_0.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                if (tglBtn1.isChecked) {
                    tglBtn1.isChecked = false
                } else {
                    tglBtn1.isChecked = true
                }
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1
            val score1: Int? = value.toInt().plus(0)
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
            val ball1: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "0"
            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = (z.toString().toString() + "," + score1.toString())
            user_view.text = f
        }
        run_1.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                if (tglBtn1.isChecked) {
                    tglBtn1.isChecked = false
                } else {
                    tglBtn1.isChecked = true
                }
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1
            val score1: Int? = value.toInt().plus(1)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run += 1
                else
                    player1Run += 1
            } else x = 0

            database1.child("Player-2").setValue(player2Run)
            database1.child("Player-1").setValue(player1Run)
            if (tglBtn1.isChecked) {
                tglBtn1.isChecked = false
            } else {
                tglBtn1.isChecked = true
            }

            database1.child(lastUpdateCount.toString()).setValue("1")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            val ball1: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "1"
            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = (z.toString() + "," + score1.toString())
            user_view.text = f
        }
        run_2.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                if (tglBtn1.isChecked) {
                    tglBtn1.isChecked = false
                } else {
                    tglBtn1.isChecked = true
                }
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1

            val score1: Int? = value.toInt().plus(2)
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

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            val ball1: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "2"
            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = (z.toString().toString() + "," + score1.toString())
            user_view.text = f
        }
        run_3.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                if (tglBtn1.isChecked) {
                    tglBtn1.isChecked = false
                } else {
                    tglBtn1.isChecked = true
                }
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1
            val score1: Int? = value.toInt().plus(3)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run += 3
                else
                    player1Run += 3
            } else x = 0

            database1.child("Player-2").setValue(player2Run)
            database1.child("Player-1").setValue(player1Run)
            if (tglBtn1.isChecked) {
                tglBtn1.isChecked = false
            } else {
                tglBtn1.isChecked = true
            }
            database1.child(lastUpdateCount.toString()).setValue("3")

            database1.child("lastUpdatedCount").setValue(lastUpdateCount)


            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            val ball1: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "3"
            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = (z.toString().toString() + "," + score1.toString())
            user_view.text = f
        }
        run_4.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                if (tglBtn1.isChecked) {
                    tglBtn1.isChecked = false
                } else {
                    tglBtn1.isChecked = true
                }
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1
            val score1: Int? = value.toInt().plus(4)
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

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            val ball1: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "4"
            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = (z.toString().toString() + "," + score1.toString())
            user_view.text = f
        }
        run_5.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                if (tglBtn1.isChecked) {
                    tglBtn1.isChecked = false
                } else {
                    tglBtn1.isChecked = true
                }
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1
            val score1: Int? = value.toInt().plus(5)
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

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            val ball1: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "5"
            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = (z.toString().toString() + "," + score1.toString())
            user_view.text = f
        }
        run_6.setOnClickListener {
            if (ball_count % 6 == 0 && ball_count != 0) {
                lastUpdateCount = 0
                if (tglBtn1.isChecked) {
                    tglBtn1.isChecked = false
                } else {
                    tglBtn1.isChecked = true
                }
            }
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1

            val score1: Int? = value.toInt().plus(6)
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

            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            val ball1: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "6"
            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = (z.toString().toString() + "," + score1.toString())
            user_view.text = f
        }
        run_increase.setOnClickListener {
            val score1: Int? = value.toInt().plus(1)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run += 1
                else
                    player1Run += 1
            } else x = 0
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "Run +1"
            val x = ball_count.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = z.toString() + "," + score1.toString()
            user_view.text = f
        }
        run_decrease.setOnClickListener {
            val score1: Int? = value.toInt().minus(1)
            myRef.setValue(score1)
            if (x == 0) {
                if (tglBtn1.isChecked)
                    player2Run -= 1
                else
                    player1Run -= 1
            } else x = 0
            database1.child("Player-1").setValue(player1Run)
            database1.child("Player-2").setValue(player2Run)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "Run -1"
            val x = ball_count.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = z.toString() + "," + score1.toString()
            user_view.text = f
        }

        ball_increase.setOnClickListener {
            val ball1: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "ball +1"
            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = z.toString() + "," + score.toString()
            user_view.text = f
        }
        ball_decrease.setOnClickListener {
            val ball1: Int? = ball_count.toInt().minus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "ball -1"
            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = z.toString() + "," + score.toString()
            user_view.text = f
        }

        wicket_minus.setOnClickListener {
            val wc: Int? = wicket_count?.toInt()!!.minus(1)
            yreff.setValue(wc)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "Wicket -1"
        }
        wicket_plus.setOnClickListener {
            val wc: Int? = wicket_count?.toInt()!!.plus(1)
            yreff.setValue(wc)

            if (ball_count % 6 == 0)
                lastUpdateCount = 0
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1

            database1.child(lastUpdateCount.toString()).setValue("wc")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)
            val ball1: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "Wicket +1"
        }
        wide_btn.setOnClickListener {
            val score1: Int? = value.toInt().plus(1)
            myRef.setValue(score1)

            if (ball_count % 6 == 0)
                lastUpdateCount = 0
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1


            database1.child(lastUpdateCount.toString()).setValue("wd")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "Wide button"
            zreff.setValue("1")
            val x = ball_count.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = z.toString() + "," + score1.toString()
            user_view.text = f
        }
        noball_btn.setOnClickListener {
            val score1: Int? = value.toInt().plus(1)
            myRef.setValue(score1)

            if (ball_count % 6 == 0)
                lastUpdateCount = 0
            if (lastUpdateCount == 10)
                lastUpdateCount = 0
            lastUpdateCount += 1


            database1.child(lastUpdateCount.toString()).setValue("nb")
            database1.child("lastUpdatedCount").setValue(lastUpdateCount)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "No ball"
            kreff.setValue("1")
            val x = ball_count.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()


            val z = w + y
            var f: String = z.toString() + "," + score1.toString()
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
            val ball1: Int? = ball_count.toInt().plus(1)
            reff.setValue(ball1)
            Toast.makeText(applicationContext, "Data updated", Toast.LENGTH_SHORT)
                .show()
            text_view.text = "lb"
            val x = ball1!!.toFloat()
            val y = ((x % 6) / 10)
            val w = (x / 6).toInt()
            val z = w + y
            var f: String = z.toString() + "," + score.toString()
            user_view.text = f

        }
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

//            setPlrName.text = setPlrName.hint as Editable?
            Toast.makeText(applicationContext, "Name Updated", Toast.LENGTH_SHORT)
                .show()

        }
        updateLastBall.setOnClickListener {
            lastUpdateCount -= 1

        }

        tglBtn1.setOnCheckedChangeListener { buttonView, isChecked ->
            val msg = "Toggle Button is " + if (isChecked) "ON" else "OFF"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        }
    }
}

