package com.example.myapplication.fragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R

class SubmitLeaveConfirmationDialogFragment : DialogFragment() {

    private var listener: SubmitLeaveListener? = null

    interface SubmitLeaveListener {
        fun onSubmitLeaveConfirmed()
        fun onSubmitLeaveCancelled()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SubmitLeaveListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement SubmitLeaveListener")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.submit_leave_title))
            .setMessage(getString(R.string.submit_leave_message))
            .setPositiveButton(getString(R.string.yes_submit)) { _, _ ->
                listener?.onSubmitLeaveConfirmed()
            }
            .setNegativeButton(getString(R.string.no_check)) { _, _ ->
                listener?.onSubmitLeaveCancelled()
            }
            .create()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        fun newInstance() = SubmitLeaveConfirmationDialogFragment()
    }
}