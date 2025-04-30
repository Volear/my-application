package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.fragments.LeaveTabFragment

class LeaveViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabNames = listOf("Annual Leave", "Sick Leave", "Other Leave")

    override fun getItemCount(): Int = tabNames.size

    override fun createFragment(position: Int): Fragment {
        return LeaveTabFragment.newInstance(tabNames[position])
    }
}