package com.example.myapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentApplyLeaveBinding

class ApplyLeaveFragment : Fragment() {
    private var _binding: FragmentApplyLeaveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentApplyLeaveBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle Apply Leave button click
        binding.applyLeaveButton.setOnClickListener {
            val leaveType = binding.leaveTypeInput.text.toString()
            val leaveDates = binding.leaveDatesInput.text.toString()

            if (leaveType.isNotEmpty() && leaveDates.isNotEmpty()) {
                // TODO: Implement leave application submission logic
                binding.statusMessage.text = "Leave application submitted!"
            } else {
                binding.statusMessage.text = "Please fill in all fields."
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}