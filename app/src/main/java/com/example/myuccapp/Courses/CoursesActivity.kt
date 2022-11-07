package com.example.myuccapp.Courses

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myuccapp.MainActivity.MainActivity
import com.example.myuccapp.R
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot


//SECTION: INFO TECH COURSES DATABASE
//-----------------------------------------------------------------------
//This activity displays the contents regarding 10 IT courses from a Firestore database
//(on Google Firebase). It displays the course ID (code), course Name, course credits, course
//pre-requisites and course descriptions in a card view.

//Link to Firestore Database on Firebase:
// https://console.cloud.google.com/firestore/data/panel/Courses?project=courses-database-9b321

class CoursesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<User>
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)


        val backButton = findViewById<Button>(R.id.back)

        backButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)        //Back to Main Menu
            }
        }

        //Info button that directs the user the UCC website page that
        //contains more details on more courses
        val infoButton2 = findViewById<Button>(R.id.infoButton2)

        infoButton2.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.ucc.edu.jm/short-courses")
            startActivity(openURL)

        }

        //RecyclerView display
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager (this)
        recyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf()

        myAdapter = MyAdapter(userArrayList)

        recyclerView.adapter = myAdapter

        eventChangeListener()

    }

    //Function that links to the Firestore database and facilitates the read and display
    //onto the recyclerview
    private fun eventChangeListener() {

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        db.collection("Courses").
                addSnapshotListener(object : EventListener<QuerySnapshot> {
                    @SuppressLint("NotifyDataSetChanged")
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?,
                    ) {
                        if (error != null){

                            Log.e("Firestore Error", error.message.toString())

                            return
                        }

                        for (dc : DocumentChange in value?.documentChanges!!){

                            if (dc.type == DocumentChange.Type.ADDED){

                                userArrayList.add(dc.document.toObject(User::class.java))
                            }
                        }

                        myAdapter.notifyDataSetChanged()

                    }

                })
    }
}