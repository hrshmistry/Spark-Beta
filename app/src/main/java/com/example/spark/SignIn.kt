package com.example.spark

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {

    private var signin_btn: Button? = null
    private var email_txt: EditText? = null
    private var pass_txt: EditText? = null
    private var firebaseAuth: FirebaseAuth? = null
    //private lateinit var btnSignin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signin_btn = findViewById(R.id.sign_in)
        email_txt = findViewById(R.id.email_txt)
        pass_txt = findViewById(R.id.pass_txt)
        firebaseAuth = FirebaseAuth.getInstance()


    }

    fun sigin_user(view: View) {
        var signin_user = email_txt?.text.toString().trim()
        var pass_user = pass_txt?.text.toString().trim()

        if (TextUtils.isEmpty(signin_user) || TextUtils.isEmpty(pass_user)) {
            Toast.makeText(applicationContext, "This field cannot be empty", Toast.LENGTH_SHORT)
                .show()
        } else {
            firebaseAuth?.signInWithEmailAndPassword(signin_user, pass_user)
                ?.addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful) {
                            Toast.makeText(
                                applicationContext,
                                "You are logged",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            var intent = Intent(this@SignIn, moderator::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Login failed",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                })
        }
    }

}