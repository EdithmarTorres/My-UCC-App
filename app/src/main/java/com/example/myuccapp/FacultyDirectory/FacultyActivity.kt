package com.example.myuccapp.FacultyDirectory

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.myuccapp.MainActivity.MainActivity
import com.example.myuccapp.R

//SECTION: FACULTY/STAFF DIRECTORY
//-----------------------------------------------------------------------
//This activity contains the directory containing the contact information
//and details for the UCC Head of Departments (HoD). It contains the picture of
//each HoD, their full name, their phone number and email address.
//Also, by tapping on the phone icon image button, the respective Head of Department
//is called. Likewise, by tapping on the email button, the respective Head of Department
//is emailed.


class FacultyActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty)

        //Back Button that connects this activity to the main menu when tapped
        val backButton = findViewById<Button>(R.id.back4)
        backButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)        //Back to Main Menu
            }
        }

        //1)HOD: SONIA

        //Initialisation of Call Button
        val callSoniaButton = findViewById<ImageButton>(R.id.callSoniaButton)

        //Commands to call the HoD's phone number on click
        callSoniaButton.setOnClickListener {
            val soniacell = "8769063000"
            val i = Intent(Intent.ACTION_CALL)
            i.data = Uri.parse("tel:$soniacell")
            startActivity(i)
            Toast.makeText(this, "Dial Extension: 4044", Toast.LENGTH_LONG).show()
        }

        //Initialisation of Email Button
        val emailSoniaButton = findViewById<ImageButton>(R.id.emailSoniaButton)

        //Commands to email the HoD's email on click
        emailSoniaButton.setOnClickListener {
            val soniaEmail = "businessadminhod@ucc.edu.jm"
            val intent = Intent(Intent.ACTION_SENDTO).apply{
                data = Uri.parse("mailto:$soniaEmail")
                putExtra(Intent.EXTRA_EMAIL,soniaEmail)
            }
            startActivity(intent)
        }



        //2) HOD: TOM

        val callTomButton = findViewById<ImageButton>(R.id.callTomButton)
        //Commands to call the HoD's phone number on click
        callTomButton.setOnClickListener {
            val tomcell = "8769063000"
            val i = Intent(Intent.ACTION_CALL)
            i.data = Uri.parse("tel:$tomcell")
            startActivity(i)
            Toast.makeText(this, "Dial Extension: 4091", Toast.LENGTH_LONG).show()

        }
        val emailTomButton = findViewById<ImageButton>(R.id.emailTomButton)
        //Commands to email the HoD's email on click
        emailTomButton.setOnClickListener {
            val tomEmail = "graduatestudiesdirector@ucc.edu.jm"
            val intent = Intent(Intent.ACTION_SENDTO).apply{
                data = Uri.parse("mailto:$tomEmail")
                putExtra(Intent.EXTRA_EMAIL,tomEmail)
            }
            startActivity(intent)
        }

        //3) HOD: IONIE

        val callIonieButton = findViewById<ImageButton>(R.id.callIonieButton)
        //Commands to call the HoD's phone number on click
         callIonieButton.setOnClickListener {
            val ioniecell = "8769063000"
            val i = Intent(Intent.ACTION_CALL)
            i.data = Uri.parse("tel:$ioniecell")
            startActivity(i)
             Toast.makeText(this, "Dial Extension: 4019", Toast.LENGTH_LONG).show()
         }
        val emailIonieButton = findViewById<ImageButton>(R.id.emailIonieButton)
        //Commands to email the HoD's email on click
        emailIonieButton.setOnClickListener {
            val ionieEmail = "appliedpsychologyfaculty@ucc.edu.jm"
            val intent = Intent(Intent.ACTION_SENDTO).apply{
                data = Uri.parse("mailto:$ionieEmail")
                putExtra(Intent.EXTRA_EMAIL,ionieEmail)
            }
            startActivity(intent)
        }

        //4) HOD: NATALIE

        val callNatalieButton = findViewById<ImageButton>(R.id.callNatalieButton)
        //Commands to call the HoD's phone number on click
        callNatalieButton.setOnClickListener {
            val natalieCell = "8769063000"
            val i = Intent(Intent.ACTION_CALL)
            i.data = Uri.parse("tel:$natalieCell")
            startActivity(i)
            Toast.makeText(this, "Dial Extension: 4046", Toast.LENGTH_LONG).show()

        }
        val emailNatalieButton = findViewById<ImageButton>(R.id.emailNatalieButton)
        //Commands to email the HoD's email on click
        emailNatalieButton.setOnClickListener {
            val natalieEmail = "ithod@ucc.edu.jm"
            val intent = Intent(Intent.ACTION_SENDTO).apply{
                data = Uri.parse("mailto:$natalieEmail")
                putExtra(Intent.EXTRA_EMAIL,natalieEmail)
            }
            startActivity(intent)
        }

        //5) HOD: PETER

        val callPeterButton = findViewById<ImageButton>(R.id.callPeterButton)
        //Commands to call the HoD's phone number on click
        callPeterButton.setOnClickListener {
            val peterCell = "8769063000"
            val i = Intent(Intent.ACTION_CALL)
            i.data = Uri.parse("tel:$peterCell")
            startActivity(i)
        }
        val emailPeterButton = findViewById<ImageButton>(R.id.emailPeterButton)
        //Commands to email the HoD's email on click
        emailPeterButton.setOnClickListener {
            val peterEmail = "headofschoolsmathit@ucc.edu.jm"
            val intent = Intent(Intent.ACTION_SENDTO).apply{
                data = Uri.parse("mailto:$peterEmail")
                putExtra(Intent.EXTRA_EMAIL,peterEmail)
            }
            startActivity(intent)
        }

        //6) HOD: COLLETTE

        val callColletteButton = findViewById<ImageButton>(R.id.callColletteButton)
        //Commands to call the HoD's phone number on click
        callColletteButton.setOnClickListener {
            val colletteCell = "8769063000"
            val i = Intent(Intent.ACTION_CALL)
            i.data = Uri.parse("tel:$colletteCell")
            startActivity(i)
            Toast.makeText(this, "Dial Extension: 4117", Toast.LENGTH_LONG).show()
        }
        val emailColletteButton = findViewById<ImageButton>(R.id.emailColletteButton)
        //Commands to email the HoD's email on click
        emailColletteButton.setOnClickListener {
            val colletteEmail = "hodtourism@ucc.edu.jm"
            val intent = Intent(Intent.ACTION_SENDTO).apply{
                data = Uri.parse("mailto:$colletteEmail")
                putExtra(Intent.EXTRA_EMAIL,colletteEmail)
            }
            startActivity(intent)
        }
    }
}