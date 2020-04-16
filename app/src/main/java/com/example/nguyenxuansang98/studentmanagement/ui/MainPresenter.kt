package com.example.nguyenxuansang98.studentmanagement.ui

import com.example.nguyenxuansang98.studentmanagement.data.DatabaseHandler
import com.example.nguyenxuansang98.studentmanagement.data.Model
import com.example.nguyenxuansang98.studentmanagement.data.Student

class MainPresenter(val view : MainContract.View,val databaseHandler: DatabaseHandler) : MainContract.Presenter {
    var model = Model(databaseHandler)
    override fun handleAddStudent(student: Student) {
        if(student.urlImageStudent.isEmpty()){
            view.addFalse("URL IMAGE IS EMPTY")
        }else if(student.nameStudent.isEmpty()){
            view.addFalse("URL IMAGE IS EMPTY")
        }else if(student.levelStudent.isEmpty()){
            view.addFalse("URL IMAGE IS EMPTY")
        }else {
            model.addStudent(student)
            view.addSuccess("ADD STUDENT SUCCESSFUL")
        }
    }

    override fun handleSelectStudent(): ArrayList<Student> {
        return model.listStudent()
    }
}