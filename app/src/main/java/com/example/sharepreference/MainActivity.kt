package com.example.sharepreference

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email = findViewById<EditText>(R.id.Email)
        val password = findViewById<EditText>(R.id.Password)
        val login = findViewById<Button>(R.id.Login)
        val show = findViewById<Button>(R.id.show)


       //create share pref with name user
        val localStorage = getSharedPreferences("user", Context.MODE_PRIVATE)
        login.setOnClickListener {
        //make editable share pref
            val editpref = localStorage.edit()
            //set data into share preference because we can't add value without editable
            editpref.putString("Email",""+email.text.toString())

            //we need to commit/apply share pref for saving value or remeembering value
            editpref.putString("Password",""+password.text.toString()).apply()

        }
        show.setOnClickListener {
           val getemail = localStorage.getString("Email","Email Not Found")
            val getpassword = localStorage.getString("Password","Password Not Found")
          Toast.makeText(this,"$getemail",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"$getpassword",Toast.LENGTH_SHORT).show()

            val intent= Intent(this,HomeActivity::class.java )
            startActivity(intent)
        }



    }
}
