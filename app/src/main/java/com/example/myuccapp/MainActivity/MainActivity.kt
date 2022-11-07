package com.example.myuccapp.MainActivity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.myuccapp.Admissions.AdmissionActivity
import com.example.myuccapp.Courses.CoursesActivity
import com.example.myuccapp.EmailFAB.EmailActivity
import com.example.myuccapp.FacultyDirectory.FacultyActivity
import com.example.myuccapp.R
import com.example.myuccapp.SocialMedia.SocialmediaActivity
import com.example.myuccapp.Timetable.TimetableActivity


//@TODO NOTE THE FOLLOWING:

//STUDENT NAME: EDITHMAR TORRES SANCHEZ
//STUDENT ID: G202200194
//DATE: SUNDAY, NOVEMBER 6TH 2022 (COMPLETION DATE)
//COURSE: MOBILE APPLICATION DEVELOPMENT (ITT420)
//ASSIGNMENT FOR UNIT 5 - SYSTEM RESPONSIVENESS AND ENHANCING USER EXPERIENCE (APP 2 OF 2)


//SUMMARY: THIS APPLICATION WAS DEVELOPED BASED ON THE INSTRUCTIONS OUTLINED IN THE
//MOBILE APPLICATION DEVELOPMENT ASSIGNMENT FOR UNIT 5. IT PROVIDES THE USER WITH DEPARTMENTAL
//INFORMATION AND RESOURCES. IT CONTAINS A FACULTY DIRECTORY FOR CALLING/EMAILING UCC STAFF &
//FACULTY, A COURSE DIRECTORY LISTING 10 I.T COURSES BEING OFFERED ALONG WITH THEIR CORRESPONDING
//DETAILS, A TIMETABLE DISPLAY SHOWING THE VARIOUS CLASSES/COURSES OFFERED THIS FALL SEMESTER,
//AN ADMISSIONS PAGE THAT PROVIDES INFORMATION ON ENTRY/ADMISSION REQUIREMENTS FOR THE IT
//DEPARTMENT AS WELL AS A LINK TO THE UCC APPLICATION PAGE, A SOCIAL MEDIA PAGE THAT CONTAINS THE
//UCC'S VARIOUS SOCIAL MEDIA PLATFORMS AND LASTLY AN EMAIL FAB THAT ALLOWS FOR AN EMAIL
//TO BE SENT DIRECTLY TO THE CURRENT IT HEAD OF DEPARTMENT.

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialisation of all of the buttons that direct to the various activities
        val directoryButton = findViewById<Button>(R.id.directoryButton)
        val courseButton = findViewById<Button>(R.id.courseButton)
        val timetableButton = findViewById<Button>(R.id.timetableButton)
        val admissionButton = findViewById<Button>(R.id.admissionButton)
        val socialmediaButton = findViewById<Button>(R.id.socialmediaButton)
        val emailfabButton = findViewById<Button>(R.id.emailfabButton)

        //Requests the permissions on startup for what we will need later in the Directory section
        requestPermissions ()

        //OnClick Listeners to initiate the various activities
        directoryButton.setOnClickListener {
            Intent(this, FacultyActivity::class.java).also {
            Toast.makeText(this, "Welcome to the Faculty Directory Page!", Toast.LENGTH_LONG).show()
                startActivity(it)        //Initiates the Faculty Activity
            }
        }

        courseButton.setOnClickListener {
            Toast.makeText(this,
                "Welcome to the Courses Page!", Toast.LENGTH_LONG).show()
            Intent(this, CoursesActivity::class.java).also {
                startActivity(it)        //Initiates the Faculty Activity
            }

        }

        timetableButton.setOnClickListener {
            Intent(this, TimetableActivity::class.java).also {
                Toast.makeText(this, "Welcome to the Timetable Page!", Toast.LENGTH_LONG).show()
                startActivity(it)        //Initiates the Timetable Activity
            }
        }

        admissionButton.setOnClickListener {
            Intent(this, AdmissionActivity::class.java).also {
                Toast.makeText(this, "Welcome to the Admissions Page!", Toast.LENGTH_LONG).show()
                startActivity(it)        //Initiates the Admissions Activity
            }
        }

        socialmediaButton.setOnClickListener {
            Intent(this, SocialmediaActivity::class.java).also {
                Toast.makeText(this, "Welcome to the Social Media Page!", Toast.LENGTH_LONG).show()
                startActivity(it)        //Initiates the Social Media Activity
            }
        }

        emailfabButton.setOnClickListener {
            Intent(this, EmailActivity::class.java).also {
                Toast.makeText(this, "Welcome to the Email FAB Page!", Toast.LENGTH_LONG).show()
                startActivity(it)        //Initiates the Email FAB Activity
            }

        }
   }

private fun permissions1() =
    ActivityCompat.checkSelfPermission(this,
        Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

private fun permissions2() =
    ActivityCompat.checkSelfPermission(this,
        Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED

private fun permissions3() =
    ActivityCompat.checkSelfPermission(this,
        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED

private fun requestPermissions () {
    val permissionsToRequest = mutableListOf<String>()
    if(!permissions1()) {
        permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }
    if(!permissions2()) {
        permissionsToRequest.add(Manifest.permission.SEND_SMS)
    }
    if(!permissions3()) {
        permissionsToRequest.add(Manifest.permission.CALL_PHONE)
    }

    if (permissionsToRequest.isNotEmpty()) {
        ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
    }

}
override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if(requestCode == 0 && grantResults.isNotEmpty()){
        for(i in grantResults.indices){
            if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                Log.d("PermisssionsRequest", "${permissions[i]} granted.")
            }
        }

    }
}
}

