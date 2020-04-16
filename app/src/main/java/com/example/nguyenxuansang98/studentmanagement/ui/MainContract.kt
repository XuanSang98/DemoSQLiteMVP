package com.example.nguyenxuansang98.studentmanagement.ui

import android.content.Context
import com.example.nguyenxuansang98.studentmanagement.data.Student

interface MainContract {

    interface View{
        fun addFalse(error:String)
        fun addSuccess(success:String)
    }
    interface Presenter{
        fun handleAddStudent(student: Student)
        fun handleSelectStudent():ArrayList<Student>
    }
}