package com.example.myapplication.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SubmitLeaveDialogFragment.SubmitLeaveListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupBottomNavigation()
        setupFab()

        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.app_name)
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> loadFragment(HomeFragment())
                R.id.navigation_leave_summary -> loadFragment(LeaveSummaryFragment())
                R.id.navigation_profile -> loadFragment(ProfileFragment())
                else -> false
            }
        }
    }

    private fun setupFab() {
        binding.fab.setOnClickListener {
            showSubmitLeaveDialog()
        }
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
        return true
    }

    private fun showSubmitLeaveDialog() {
        val dialog = SubmitLeaveDialogFragment.newInstance()
        dialog.show(supportFragmentManager, "SubmitLeaveDialogFragment")
    }

    override fun onSubmitLeave() {
        Toast.makeText(this, getString(R.string.leave_submitted), Toast.LENGTH_SHORT).show()
        // Refresh the current fragment or navigate to leave summary
        binding.bottomNavigation.selectedItemId = R.id.navigation_leave_summary
    }

    override fun onCancelLeave() {
        Toast.makeText(this, getString(R.string.leave_cancelled), Toast.LENGTH_SHORT).show()
    }
}