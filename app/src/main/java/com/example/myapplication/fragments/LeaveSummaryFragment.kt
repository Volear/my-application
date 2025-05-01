package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLeaveSummaryBinding
import com.google.android.material.snackbar.Snackbar

class LeaveSummaryFragment : Fragment() {
    private var _binding: FragmentLeaveSummaryBinding? = null
    private val binding get() = _binding!!

    private lateinit var leaveSummaryAdapter: LeaveSummaryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaveSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupSubmitLeaveButton()
    }

    private fun setupRecyclerView() {
        leaveSummaryAdapter = LeaveSummaryAdapter { clickedItem ->
            showMessage("Clicked: ${clickedItem.leaveType}")
        }

        binding.recyclerViewLeaves.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = leaveSummaryAdapter
        }

        // Load initial data
        loadLeaveItems()
    }

    private fun loadLeaveItems() {
        val leaveItems = listOf(
            LeaveSummaryItem(1, "Sick Leave", "Approved", "1 May 2025 - 3 May 2025"),
            LeaveSummaryItem(2, "Casual Leave", "Pending", "5 May 2025 - 6 May 2025"),
            LeaveSummaryItem(3, "Vacation Leave", "Rejected", "10 May 2025 - 15 May 2025")
        )
        leaveSummaryAdapter.submitList(leaveItems)
    }

    private fun setupSubmitLeaveButton() {
        binding.submitLeaveButton.setOnClickListener {
            // TODO: Implement submit leave functionality
            showMessage(getString(R.string.submit_leave_message))
        }
    }

    private fun showMessage(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}