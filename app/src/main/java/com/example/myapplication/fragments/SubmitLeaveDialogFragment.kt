package com.example.myapplication.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.myapplication.databinding.DialogSubmitLeaveBinding

class SubmitLeaveDialogFragment : DialogFragment() {

    private var _binding: DialogSubmitLeaveBinding? = null
    private val binding get() = _binding!!
    private var listener: SubmitLeaveListener? = null

    interface SubmitLeaveListener {
        fun onSubmitLeave()
        fun onCancelLeave()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SubmitLeaveListener) {
            listener = context
        } else {
            throw ClassCastException("$context must implement SubmitLeaveListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogSubmitLeaveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle "Yes, Submit" button
        binding.btnSubmit.setOnClickListener {
            listener?.onSubmitLeave() // Notify listener
            dismiss() // Close the dialog
        }

        // Handle "No, Let me check" button
        binding.btnCancel.setOnClickListener {
            listener?.onCancelLeave() // Notify listener
            dismiss() // Close the dialog
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }
}