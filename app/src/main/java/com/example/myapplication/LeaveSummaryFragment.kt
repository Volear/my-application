package com.example.myapplication

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

        // Sample data
        val leaveList = listOf("Annual Leave", "Sick Leave", "Casual Leave")

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = LeaveAdapter(leaveList)

        // Show dialog on button click
        binding.submitLeaveButton.setOnClickListener {
            val dialog = SubmitLeaveDialogFragment()
            dialog.show(parentFragmentManager, "SubmitLeaveDialog")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}