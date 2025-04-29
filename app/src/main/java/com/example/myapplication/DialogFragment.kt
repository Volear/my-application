package com.example.myapplication

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog

class SubmitLeaveConfirmationDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Submit Leave")
            .setMessage("Double-check your leave details to ensure everything is correct. Do you want to proceed?")
            .setPositiveButton("Yes, Submit") { _, _ ->
                // Handle submit logic here
            }
            .setNegativeButton("No, Let me check") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }
}