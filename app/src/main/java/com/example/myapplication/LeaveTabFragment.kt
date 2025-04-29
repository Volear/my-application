package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentTabBinding

class LeaveTabFragment : Fragment() {

    private var _binding: FragmentTabBinding? = null
    private val binding get() = _binding!!

    private var tabName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tabName = it.getString(ARG_TAB_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Update text to show which tab we're in
        binding.textView.text = when (tabName) {
            "Pending" -> "Your pending leave requests will appear here"
            "Approved" -> "Your approved leave requests will appear here"
            else -> tabName
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_TAB_NAME = "tab_name"

        fun newInstance(tabName: String): LeaveTabFragment {
            return LeaveTabFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TAB_NAME, tabName)
                }
            }
        }
    }
}