package com.example.nguyenxuansang98.studentmanagement.data

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class Model( val database : DatabaseHandler) : IModel {

    override fun addStudent(student: Student) {
        var sqlDatabase :SQLiteDatabase = database.writableDatabase
        var contentValues = ContentValues()
        //contentValues.put(DatabaseHandler.ID_STUDENT,student.idStudent)
        contentValues.put(DatabaseHandler.URL_IMAGE,student.urlImageStudent)
        contentValues.put(DatabaseHandler.NAME_STUDENT,student.nameStudent)
        contentValues.put(DatabaseHandler.LEVEL_STUDENT,student.levelStudent)
        sqlDatabase.insert(DatabaseHandler.TABLE_NAME,null,contentValues)
        sqlDatabase.close()
    }

    override fun listStudent(): ArrayList<Student> {
        var arrayStudent : ArrayList<Student> = arrayListOf()
        var query = "SELECT * FROM "+DatabaseHandler.TABLE_NAME
        var sqlDatabase = database.readableDatabase
        var cusor : Cursor = sqlDatabase.rawQuery(query,null)
        cusor.moveToFirst()
        while (cusor.isAfterLast()==false){
            var student = Student(cusor.getString(1),cusor.getString(2),cusor.getString(3))
            arrayStudent.add(student)
            cusor.moveToNext()
        }
        return arrayStudent
    }
}