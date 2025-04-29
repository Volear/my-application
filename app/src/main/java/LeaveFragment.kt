package com.example.leaveapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.leaveapp.databinding.FragmentLeaveBinding
import com.google.android.material.tabs.TabLayoutMediator

class LeaveFragment : Fragment() {

    private var _binding: FragmentLeaveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up ViewPager with adapter
        val pagerAdapter = LeaveTabAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        // Connect TabLayout with ViewPager
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Pending"
                1 -> tab.text = "Approved"
                2 -> tab.text = "Submit Leave"
            }
        }.attach()

        // Add a special click listener for the "Submit Leave" tab
        binding.tabLayout.addOnTabSelectedListener(object : com.google.android.material.tabs.TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: com.google.android.material.tabs.TabLayout.Tab?) {
                if (tab?.position == 2) { // Submit Leave tab
                    showSubmitLeaveDialog()
                }
            }

            override fun onTabUnselected(tab: com.google.android.material.tabs.TabLayout.Tab?) {}
            override fun onTabReselected(tab: com.google.android.material.tabs.TabLayout.Tab?) {
                if (tab?.position == 2) { // Submit Leave tab
                    showSubmitLeaveDialog()
                }
            }
        })
    }

    private fun showSubmitLeaveDialog() {
        val dialog = SubmitLeaveDialogFragment()
        dialog.show(childFragmentManager, "SubmitLeaveDialog")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}