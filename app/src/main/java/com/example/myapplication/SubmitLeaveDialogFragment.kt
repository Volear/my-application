package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.myapplication.databinding.DialogSubmitLeaveBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class SubmitLeaveDialogFragment : DialogFragment() {

    private var _binding: DialogSubmitLeaveBinding? = null
    private val binding get() = _binding!!

    private val calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

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

        // Set up date pickers
        binding.btnFromDate.setOnClickListener {
            showDatePicker(true)
        }

        binding.btnToDate.setOnClickListener {
            showDatePicker(false)
        }

        binding.btnConfirm.setOnClickListener {
            // Validate and submit leave request
            if (validateForm()) {
                // Here you would normally send the data to your backend
                Toast.makeText(context, "Leave request submitted!", Toast.LENGTH_SHORT).show()
                dismiss()
            }
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun validateForm(): Boolean {
        // Basic validation example
        if (binding.etLeaveReason.text.isNullOrEmpty()) {
            binding.etLeaveReason.error = "Please enter a reason"
            return false
        }

        if (binding.btnFromDate.text == "Select Date" || binding.btnToDate.text == "Select Date") {
            Toast.makeText(context, "Please select both dates", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun showDatePicker(isFromDate: Boolean) {
        val datePicker = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val formattedDate = dateFormat.format(calendar.time)
                if (isFromDate) {
                    binding.btnFromDate.text = formattedDate
                } else {
                    binding.btnToDate.text = formattedDate
                }
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        // Set min date to today for "from date"
        if (isFromDate) {
            datePicker.datePicker.minDate = System.currentTimeMillis()
        }

        datePicker.show()
    }

    override fun onStart() {
        super.onStart()
        // Make the dialog wider
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}