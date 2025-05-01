package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentLeaveSummaryBinding

class LeaveSummaryFragment : Fragment() {
    private var _binding: FragmentLeaveSummaryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaveSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val leaveItems = listOf(
            LeaveSummaryItem("Sick Leave", "Approved", "1 May 2025 - 3 May 2025"),
            LeaveSummaryItem("Casual Leave", "Pending", "5 May 2025 - 6 May 2025"),
            LeaveSummaryItem("Vacation Leave", "Rejected", "10 May 2025 - 15 May 2025")
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = LeaveSummaryAdapter(leaveItems)

        binding.submitLeaveButton.setOnClickListener {
            // TODO: Implement button action
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}