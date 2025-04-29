package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.com.example.myapplication.LeaveTabFragment
import com.example.myapplication.databinding.DialogSubmitLeaveBinding

class LeaveTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LeaveTabFragment.newInstance("Pending")
            1 -> LeaveTabFragment.newInstance("Approved")
            2 -> LeaveTabFragment.newInstance("Submit Leave")
            else -> LeaveTabFragment.newInstance("Unknown")
        }
    }
}