package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentApplyLeaveBinding
import com.google.android.material.snackbar.Snackbar

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupApplyLeaveButton()
    }

    private fun setupApplyLeaveButton() {
        binding.applyLeaveButton.setOnClickListener {
            val leaveType = binding.leaveTypeInput.text.toString().trim()
            val leaveDates = binding.leaveDatesInput.text.toString().trim()

            if (leaveType.isNotEmpty() && leaveDates.isNotEmpty()) {
                submitLeaveApplication()
            } else {
                showErrorMessage(getString(R.string.fill_all_fields))
            }
        }
    }

    private fun submitLeaveApplication() {
        // TODO: Implement leave application submission logic
        showSuccessMessage(getString(R.string.leave_application_submitted))
    }

    private fun showSuccessMessage(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
            .setBackgroundTint(resources.getColor(R.color.error_color, null))
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}