package com.example.nguyenxuansang98.studentmanagement.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nguyenxuansang98.studentmanagement.R
import com.example.nguyenxuansang98.studentmanagement.data.Student
import kotlinx.android.synthetic.main.item_student.view.*

class StudentAdapter(val arrayStudent : ArrayList<Student>) : RecyclerView.Adapter<StudentAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student,parent,false))

    override fun getItemCount(): Int = arrayStudent.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun binData(){
            Glide.with(itemView).load(arrayStudent.get(adapterPosition).urlImageStudent).into(itemView.image_item_student)
            itemView.text_name_item_student.text = arrayStudent.get(adapterPosition).nameStudent
            itemView.text_level_item_student.text = arrayStudent.get(adapterPosition).levelStudent
        }

    }
}