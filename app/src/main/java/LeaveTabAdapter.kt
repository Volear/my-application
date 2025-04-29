package com.example.leaveapp

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LeaveTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LeaveTabFragment.newInstance("Pending")
            1 -> LeaveTabFragment.newInstance("Approved")
            2 -> LeaveTabFragment.newInstance("Submit")
            else -> LeaveTabFragment.newInstance("Default")
        }
    }
}