package com.example.myapplication.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity(), SubmitLeaveDialogFragment.SubmitLeaveListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showSubmitLeaveDialog()
    }

    private fun showSubmitLeaveDialog() {
        val dialog = SubmitLeaveDialogFragment()
        dialog.show(supportFragmentManager, "SubmitLeaveDialogFragment")
    }

    override fun onSubmitLeave() {
        Toast.makeText(this, "Leave submitted successfully!", Toast.LENGTH_SHORT).show()
    }

    override fun onCancelLeave() {
        Toast.makeText(this, "Leave submission canceled.", Toast.LENGTH_SHORT).show()
    }
}