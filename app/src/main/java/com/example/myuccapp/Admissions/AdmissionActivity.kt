package com.example.myuccapp.Admissions

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myuccapp.MainActivity.MainActivity
import com.example.myuccapp.R


//SECTION: ADMISSIONS AND ENTRY REQUIREMENTS ACTIVITY
//-----------------------------------------------------------------------
//This activity displays the list of entry requirements needed for the Bsc in Information
//Technology including academic and english language requirements. It also includes
//an "Apply Here" button that directs the user to the UCC's application page. Additionally
//it displays an "Info" button that directs the user to the programme's information
//website, to allow them to see more details.


class AdmissionActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admission)

        val backButton = findViewById<Button>(R.id.back1)

        backButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)        //Back to Main Menu
            }
        }


        //Directs the user to the UCC's application website page
        val applyButton = findViewById<Button>(R.id.applyButton)

        applyButton.setOnClickListener {
            val uccApply = "https://apply.online.ucc.edu.jm/s/login/?ec=302&startURL=%2Fs%2F"
            val packager = "com.android.chrome"

            openLink(uccApply, packager, uccApply)

        }

        //This info button directs the user to the UCC's Bsc in IT info page
        val infoButton = findViewById<Button>(R.id.infoButton)

        infoButton.setOnClickListener {
            val uccInfo = "https://online.ucc.edu.jm/programmes/bsc-information-technology/"
            val package1 = "com.android.chrome"

            openLink(uccInfo, package1, uccInfo)

        }

    }

    //Function that facilitates opening links to websites,social media platforms etc.
    private fun openLink(appLink: String, packager: String, uccFb: String) {

        try {
            val uri: Uri = Uri.parse(appLink)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            intent.setPackage(packager)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            startActivity(intent)
        } catch (ActivityNotFoundException: Throwable) {

            val uri: Uri = Uri.parse(uccFb)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)

        }

    }
}