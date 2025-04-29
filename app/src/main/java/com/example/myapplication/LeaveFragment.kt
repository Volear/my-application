package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentLeaveBinding
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

        // Set up ViewPager with adapter (only for the first two tabs)
        val pagerAdapter = LeaveTabAdapter(this)
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.isUserInputEnabled = true

        // Connect TabLayout with ViewPager
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.pending)
                1 -> tab.text = getString(R.string.approved)
            }
        }.attach()

        // Add the Submit Leave tab manually since it won't be part of the ViewPager
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(getString(R.string.submit_leave)))

        // Add a special click listener for the "Submit Leave" tab
        binding.tabLayout.addOnTabSelectedListener(object : com.google.android.material.tabs.TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: com.google.android.material.tabs.TabLayout.Tab?) {
                if (tab?.position == 2) { // Submit Leave tab
                    showSubmitLeaveDialog()
                    // Return to the previous tab after showing the dialog
                    binding.tabLayout.selectTab(binding.tabLayout.getTabAt(0))
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