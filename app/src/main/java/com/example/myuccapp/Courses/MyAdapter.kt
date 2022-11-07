package com.example.myuccapp.Courses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myuccapp.R

class MyAdapter(private val userList : ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
        parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val user: User = userList[position]
        holder.courseID.text = user.courseID
        holder.courseName.text = user.courseName
        holder.courseCredits.text = user.courseCredits
        holder.coursePrerequisites.text = user.coursePrerequisites
        holder.courseDescription.text = user.courseDescription
    }

    override fun getItemCount(): Int{

        return userList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val courseID : TextView = itemView.findViewById(R.id.courseID)
        val courseName : TextView = itemView.findViewById(R.id.courseName)
        val courseCredits : TextView = itemView.findViewById(R.id.courseCredits)
        val coursePrerequisites : TextView = itemView.findViewById(R.id.coursePrerequisites)
        val courseDescription : TextView = itemView.findViewById(R.id.courseDescription)

    }

}