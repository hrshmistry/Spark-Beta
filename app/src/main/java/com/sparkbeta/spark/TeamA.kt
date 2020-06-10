package com.sparkbeta.spark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.*

class TeamAFragment : Fragment() {

    private var play1: TextView?= null
    private var play2: TextView?= null
    private var play3: TextView?= null
    private var play4: TextView?= null
    private var play5: TextView?= null
    private var play6: TextView?= null
    private var play7: TextView?= null
    private var play8: TextView?= null
    private var play9: TextView?= null
    private var play10: TextView?= null
    private var play11: TextView?= null

    private var r1:TextView?=null
    private var r2:TextView?=null
    private var r3:TextView?=null
    private var r4:TextView?=null
    private var r5:TextView?=null
    private var r6:TextView?=null
    private var r7:TextView?=null
    private var r8:TextView?=null
    private var r9:TextView?=null
    private var r10:TextView?=null
    private var r11:TextView?=null

    private var nameA:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Fragment.
        // val manager: FragmentManager = getSupportFragmentManager()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
//        runPerOver = getView().findViewById(R.id.runPerOver)
//        runPerOver.setOnClickListener{
//            runPerOver.text = "here we go"
//        }
        return inflater.inflate(R.layout.fragment_team_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //   runPerOver.text= "hey"

        val applicationContext = null

        nameA=view?.findViewById(R.id.team_name)

        val database1:FirebaseDatabase = FirebaseDatabase.getInstance()
        val Bref: DatabaseReference = database1.getReference("cricket").child("Team A").child("NameA")

        Bref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                nameA?.text = dataSnapshot.getValue(String::class.java)!!
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        val ref = FirebaseDatabase.getInstance().getReference("cricket").child("Team A")
        val runs1=ref.child("1").child("run")
        val p1=ref.child("1").child("name")
        val runs2=ref.child("2").child("run")
        val p2=ref.child("2").child("name")
        val runs3=ref.child("3").child("run")
        val p3=ref.child("3").child("name")
        val runs4=ref.child("4").child("run")
        val p4=ref.child("4").child("name")
        val runs5=ref.child("5").child("run")
        val p5=ref.child("5").child("name")
        val runs6=ref.child("6").child("run")
        val p6=ref.child("6").child("name")
        val runs7=ref.child("7").child("run")
        val p7=ref.child("7").child("name")
        val runs8=ref.child("8").child("run")
        val p8=ref.child("8").child("name")
        val runs9=ref.child("9").child("run")
        val p9=ref.child("9").child("name")
        val runs10=ref.child("10").child("run")
        val p10=ref.child("10").child("name")
        val runs11=ref.child("11").child("run")
        val p11=ref.child("11").child("name")

        play1 = view?.findViewById(R.id.play1)
        play2 = view?.findViewById(R.id.play2)
        play3 = view?.findViewById(R.id.play3)
        play4 = view?.findViewById(R.id.play4)
        play5 = view?.findViewById(R.id.play5)
        play6 = view?.findViewById(R.id.play6)
        play7 = view?.findViewById(R.id.play7)
        play8 = view?.findViewById(R.id.play8)
        play9 = view?.findViewById(R.id.play9)
        play10 = view?.findViewById(R.id.play10)
        play11 = view?.findViewById(R.id.play11)

        r1=view?.findViewById(R.id.r1)
        r2=view?.findViewById(R.id.r2)
        r3=view?.findViewById(R.id.r3)
        r4=view?.findViewById(R.id.r4)
        r5=view?.findViewById(R.id.r5)
        r6=view?.findViewById(R.id.r6)
        r7=view?.findViewById(R.id.r7)
        r8=view?.findViewById(R.id.r8)
        r9=view?.findViewById(R.id.r9)
        r10=view?.findViewById(R.id.r10)
        r11=view?.findViewById(R.id.r11)

        runs1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                r1?.text= dataSnapshot.getValue(String::class.java)!!
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                play1?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        runs2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                r2?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                play2?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        runs3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                r3?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                play3?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        runs4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                r4?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p4.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                play4?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        runs5.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                r5?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p5.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                play5?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        runs6.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                r6?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p6.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                play6?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        runs7.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                r7?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p7.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                play7?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        runs8.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                r8?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p8.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                play8?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        runs9.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                r9?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p9.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                play9?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })


        runs10.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                r10?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p10.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                play10?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        runs11.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                r11?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

        p11.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                play11?.text = dataSnapshot.getValue(String::class.java)!!.toString()
            }

            override fun onCancelled(error: DatabaseError) { // Failed to read value
                Toast.makeText(applicationContext, "No updated", Toast.LENGTH_SHORT).show()
            }
        })

    }

}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------
