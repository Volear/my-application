package com.example.myapplication.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        setupRecyclerView()

        // Set default fragment
        loadFragment(HomeFragment())

        // Handle BottomNavigationView item selection
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_leave_summary -> {
                    loadFragment(LeaveTabFragment())
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun setupRecyclerView() {
        // Example data to display in RecyclerView
        val exampleData = listOf("Item 1", "Item 2", "Item 3", "Item 4")

        // Set layout manager
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Set adapter
        binding.recyclerView.adapter = ExampleAdapter(exampleData)
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
        return true
    }
}