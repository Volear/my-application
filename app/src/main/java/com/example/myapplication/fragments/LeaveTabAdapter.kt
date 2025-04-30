package com.example.myapplication.fragments

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LeaveTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2 // Only Pending and Approved tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LeaveTabFragment.newInstance("Pending")
            1 -> LeaveTabFragment.newInstance("Approved")
            else -> LeaveTabFragment.newInstance("Unknown")
        }
    }
}