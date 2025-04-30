package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentLeaveTabBinding

class LeaveTabFragment : Fragment() {

    private var _binding: FragmentLeaveTabBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_TAB_NAME = "tab_name"

        fun newInstance(tabName: String): LeaveTabFragment {
            val fragment = LeaveTabFragment()
            val args = Bundle()
            args.putString(ARG_TAB_NAME, tabName)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaveTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the tab name passed in arguments
        val tabName = arguments?.getString(ARG_TAB_NAME)

        // Use tabName to display data specific to the tab
        binding.textViewTabName.text = tabName
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}