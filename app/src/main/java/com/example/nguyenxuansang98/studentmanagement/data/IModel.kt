package com.example.nguyenxuansang98.studentmanagement.data

interface IModel {
    fun addStudent(student: Student)
    fun listStudent():ArrayList<Student>
}