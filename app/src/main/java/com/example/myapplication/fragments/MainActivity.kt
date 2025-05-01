package com.example.myapplication.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SubmitLeaveDialogFragment.SubmitLeaveListener {

    // Using View Binding to access views in activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        // Set up RecyclerView
        setupRecyclerView()

        // Set up FloatingActionButton click listener
        binding.fab.setOnClickListener {
            showSubmitLeaveDialog()
        }
    }

    // Method to set up RecyclerView
    private fun setupRecyclerView() {
        val sampleData = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = ExampleAdapter(sampleData)
    }

    // Show SubmitLeaveDialogFragment
    private fun showSubmitLeaveDialog() {
        val dialog = SubmitLeaveDialogFragment()
        dialog.show(supportFragmentManager, "SubmitLeaveDialogFragment")
    }

    // Handle dialog submit action
    override fun onSubmitLeave() {
        Toast.makeText(this, "Leave submitted successfully!", Toast.LENGTH_SHORT).show()
    }

    // Handle dialog cancel action
    override fun onCancelLeave() {
        Toast.makeText(this, "Leave submission canceled.", Toast.LENGTH_SHORT).show()
    }
}