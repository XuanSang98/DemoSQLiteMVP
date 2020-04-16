package com.example.nguyenxuansang98.studentmanagement.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nguyenxuansang98.studentmanagement.R
import com.example.nguyenxuansang98.studentmanagement.data.DatabaseHandler
import com.example.nguyenxuansang98.studentmanagement.data.Student
import kotlinx.android.synthetic.main.activity_custom_add_dialog.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainContract.View {
    private lateinit var presenter  : MainPresenter
    private lateinit var database  : DatabaseHandler
    private lateinit var adapterStudent  : StudentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        database = DatabaseHandler(this)
        presenter = MainPresenter(this,database)
        adapterStudent = StudentAdapter(presenter.handleSelectStudent())
        Log.e("Size",""+presenter.handleSelectStudent().size)
        recyclerview_student.layoutManager = LinearLayoutManager(this)
        recyclerview_student.adapter = adapterStudent
    }

    fun createDialog() {
        val diaLogView = LayoutInflater.from(this).inflate(R.layout.activity_custom_add_dialog, null)
        val builder = AlertDialog.Builder(this).setView(diaLogView).show()
        diaLogView.button_add_dialog.setOnClickListener {
            var student = Student(diaLogView.edittext_url_image.text.toString(),
                diaLogView.edittext_name.text.toString(),diaLogView.edittext_level.text.toString())
            presenter.handleAddStudent(student)
            adapterStudent = StudentAdapter(presenter.handleSelectStudent())
            recyclerview_student.adapter = adapterStudent
            builder.dismiss()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_add ->{
                createDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun addFalse(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    override fun addSuccess(success: String) {
        Toast.makeText(this,success,Toast.LENGTH_SHORT).show()
    }

}
