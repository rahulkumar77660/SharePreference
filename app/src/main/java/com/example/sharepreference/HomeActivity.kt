package com.example.sharepreference

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val localStorage =getSharedPreferences("user",Context.MODE_PRIVATE)

        val getemail = localStorage.getString("Email","Email Not Found")
        val getpassword = localStorage.getString("Password","Password Not Found")



        val email1 = findViewById<TextView>(R.id.email)
        val password1 = findViewById<TextView>(R.id.password1)
        email1.text=getemail.toString()
        password1.text=getpassword.toString()
    }
}