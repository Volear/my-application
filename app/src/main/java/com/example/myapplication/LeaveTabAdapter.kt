package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.com.example.myapplication.LeaveTabFragment
import com.example.myapplication.databinding.DialogSubmitLeaveBinding

class SubmitLeaveDialogFragment : DialogFragment() {

    private var _binding: DialogSubmitLeaveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogSubmitLeaveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfirm.setOnClickListener {
            // Add your confirm logic here
            dismiss()
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class LeaveTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    // We have 3 tabs: Pending, Approved, Submit Leave
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        // Create a fragment for each tab
        return when (position) {
            0 -> LeaveTabFragment.newInstance("Pending")
            1 -> LeaveTabFragment.newInstance("Approved")
            2 -> LeaveTabFragment.newInstance("Submit Leave")
            else -> LeaveTabFragment.newInstance("Unknown")
        }
    }
}