package com.example.myuccapp.Timetable

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myuccapp.MainActivity.MainActivity
import com.example.myuccapp.R


//SECTION: FALL SEMESTER TIMETABLE ACTIVITY
//-----------------------------------------------------------------------
//This activity displays the list of courses/classes that have been or will be offered
//for the Fall 2022 semester (August to December 2022) for the Bachelors Degree in
//Information Technology programme to provide referencing for IT students.


class TimetableActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)


        //Directs user back to the main menu
        val backButton = findViewById<Button>(R.id.back6)

        backButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)        //Back to Main Menu
            }
        }

        //This learn more button directs the user to the list of classes offered for the the programme
        val learnmoreButton = findViewById<Button>(R.id.learnmoreButton)

        learnmoreButton.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://online.ucc.edu.jm/programmes/bsc-information-technology/#module-component")
            startActivity(openURL)
        }

    }
}