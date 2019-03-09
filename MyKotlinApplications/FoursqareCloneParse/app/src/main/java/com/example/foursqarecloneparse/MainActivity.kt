package com.example.foursqarecloneparse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.parse.LogInCallback
import com.parse.ParseException
import com.parse.ParseObject
import com.parse.ParseUser
import com.parse.SaveCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }
    fun signIn(view: View){
        ParseUser.logInInBackground(usernameText.text.toString(),passwordText.text.toString(), LogInCallback { user, e ->
            if(e != null){
                Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()
            }else{
                    Toast.makeText(applicationContext,"Welcome ${ParseUser.getCurrentUser().username}",Toast.LENGTH_LONG).show()
                    val intent = Intent(applicationContext,LocationsActivity::class.java)
                    startActivity(intent)
            }
        })

    }
    fun signUp(view: View){
        val user = ParseUser();
        user.username = usernameText.text.toString()
        user.setPassword(passwordText.text.toString())
        user.signUpInBackground { e ->
            if(e != null){
                Toast.makeText(applicationContext,e.localizedMessage,Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext,"User Created",Toast.LENGTH_LONG).show()
                val intent = Intent(applicationContext,LocationsActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
