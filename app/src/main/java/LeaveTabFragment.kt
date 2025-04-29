package com.example.leaveapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.leaveapp.databinding.FragmentTab1Binding

class LeaveTabFragment : Fragment() {

    private var _binding: FragmentTab1Binding? = null
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
        _binding = FragmentTab1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Update text to show which tab we're in
        binding.textView.text = tabName
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