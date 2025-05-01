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

    companion object {
        fun newInstance(): SubmitLeaveDialogFragment {
            return SubmitLeaveDialogFragment()
        }
    }

    interface SubmitLeaveListener {
        fun onSubmitLeave()
        fun onCancelLeave()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SubmitLeaveListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement SubmitLeaveListener")
        }
    }

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

        binding.submitButton.setOnClickListener {
            listener?.onSubmitLeave()
            dismiss()
        }

        binding.cancelButton.setOnClickListener {
            listener?.onCancelLeave()
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}