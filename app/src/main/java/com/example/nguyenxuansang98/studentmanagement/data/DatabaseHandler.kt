package com.example.nguyenxuansang98.studentmanagement.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) :SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION){

    companion object{
        val DATABASE_NAME ="DatabaseStudent"
        val DATABASE_VERSION =1
        val TABLE_NAME = "Student"
        val ID_STUDENT = "IdStudent"
        val URL_IMAGE = "UrlImage"
        val NAME_STUDENT = "NameStudent"
        val LEVEL_STUDENT = "LevelStudent"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableStudent = String.format("CREATE TABLE %s (%s IDENTITY(1,1) PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)",
            TABLE_NAME, ID_STUDENT,URL_IMAGE, NAME_STUDENT, LEVEL_STUDENT)
        db?.execSQL(createTableStudent)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}