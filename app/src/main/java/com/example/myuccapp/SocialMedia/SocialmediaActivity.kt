package com.example.myuccapp.SocialMedia

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myuccapp.MainActivity.MainActivity
import com.example.myuccapp.R


//SECTION: UCC SOCIAL MEDIA ACTIVITY
//-----------------------------------------------------------------------
//This activity displays a list of buttons that direct the user to the UCC's various social media
//platforms such as Facebook, Twitter, Instagram and the main UCC website.

class SocialmediaActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_socialmedia)


        val backButton = findViewById<Button>(R.id.back5)

        backButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)        //Back to Main Menu
            }
        }

        //UCC FACEBOOK PAGE LAUNCHER
        val facebookButton = findViewById<Button>(R.id.facebookButon)

        facebookButton.setOnClickListener {
            val uccFb = "https://www.facebook.com/uccjamaica"
            val packager1 = "com.facebook.katana"

            openLink(uccFb,packager1,uccFb)
        }


        //UCC TWITTER PAGE LAUNCHER
        val twitterButton = findViewById<Button>(R.id.twitterButton)

        twitterButton.setOnClickListener {
            val uccTwitter = "https://twitter.com/uccjamaica"
            val packager2 = "com.twitter.android"

            openLink(uccTwitter,packager2,uccTwitter)

        }

        //UCC INSTAGRAM PAGE LAUNCHER
        val instagramButton = findViewById<Button>(R.id.instagramButton)

        instagramButton.setOnClickListener {
            val uccInsta = "https://www.instagram.com/uccjamaica/"
            val packager3 = "com.instagram.android"

            openLink(uccInsta,packager3,uccInsta)
        }


        //UCC WEBSITE PAGE LAUNCHER
        val websiteButton = findViewById<Button>(R.id.websiteButton)

        websiteButton.setOnClickListener {
            val uccWeb = "https://www.ucc.edu.jm/"
            val packager3 = "com.android.chrome"

            openLink(uccWeb,packager3,uccWeb)

        }


    }

    //Function
    //that verifies whether the application is on the phone if not opens the link on the browser
    private fun openLink(appLink: String, packager: String, uccFb: String) {

        try{
            val uri : Uri = Uri.parse(appLink)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            intent.setPackage(packager)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            startActivity(intent)
        }catch (ActivityNotFoundException : Throwable) {

            val uri : Uri = Uri.parse(uccFb)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)

        }

    }
}