package com.example.myuccapp.EmailFAB

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myuccapp.MainActivity.MainActivity
import com.example.myuccapp.R


//SECTION: EMAIL FAB ACTIVITY
//-----------------------------------------------------------------------
//This activity presents the UCC's IT Head of Department and allows the user to
//directly send her an email by clicking on the "EMAIL HOD" button.


class EmailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        val backButton = findViewById<Button>(R.id.back3)

        backButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)        //Back to Main Menu
            }
        }

        //Emails the IT Head of Department (EMAIL FAB)
        val emailhodButton = findViewById<Button>(R.id.emailhodButton)

        emailhodButton.setOnClickListener {
            val hodEmail = "ithod@ucc.edu.jm"
            val intent = Intent(Intent.ACTION_SENDTO).apply{
                data = Uri.parse("mailto: $hodEmail")
                putExtra(Intent.EXTRA_EMAIL,hodEmail)
            }
            startActivity(intent)
        }

    }
}