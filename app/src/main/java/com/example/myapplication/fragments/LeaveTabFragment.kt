package com.example.myapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentLeaveTabBinding
import com.google.android.material.snackbar.Snackbar

class LeaveTabFragment : Fragment() {

    private var _binding: FragmentLeaveTabBinding? = null
    private val binding get() = _binding!!

    private var tabType: String? = null

    companion object {
        private const val ARG_TAB_TYPE = "tab_type"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tabType = arguments?.getString(ARG_TAB_TYPE)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLeaveTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    @SuppressLint("SetTextI18n")
    private fun setupUI() {
        binding.tabTypeTextView.text = "Tab Type: $tabType"
        binding.actionButton.setOnClickListener {
            performAction()
        }
    }

    private fun performAction() {
        when (tabType) {
            "Apply" -> applyForLeave()
            "Approve" -> approveLeave()
            "Summary" -> showLeaveSummary()
            else -> showMessage("Unknown tab type")
        }
    }

    private fun applyForLeave() {
        showMessage("Applying for leave")
    }

    private fun approveLeave() {
        showMessage("Approving leave")
    }

    private fun showLeaveSummary() {
        showMessage("Showing leave summary")
    }

    private fun showMessage(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}