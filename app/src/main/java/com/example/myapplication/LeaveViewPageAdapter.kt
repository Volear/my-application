package com.example.leaveapp.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.leaveapp.fragments.LeaveTabFragment

class LeaveViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    // Define the number of tabs
    private val TAB_COUNT = 3

    override fun getItemCount(): Int = TAB_COUNT

    override fun createFragment(position: Int): Fragment {
        // Create a new instance of LeaveTabFragment with different tab names
        return when (position) {
            0 -> LeaveTabFragment.newInstance("Annual Leave")
            1 -> LeaveTabFragment.newInstance("Sick Leave")
            2 -> LeaveTabFragment.newInstance("Other Leave")
            else -> LeaveTabFragment.newInstance("Unknown Tab")
        }
    }
}