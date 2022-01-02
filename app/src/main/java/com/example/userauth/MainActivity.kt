package com.example.userauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userName: String = intent.getStringExtra("name").toString()
        var email: String = intent.getStringExtra("email").toString()

        if(userName != null && email != null){
            nameTv.text = userName
            emailTv.text= email
        }

    }
}