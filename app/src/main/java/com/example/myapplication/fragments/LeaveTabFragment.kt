package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment

class LeaveTabFragment : Fragment() {

    companion object {
        private const val ARG_TAB_TYPE = "tab_type"

        fun newInstance(tabType: String): LeaveTabFragment {
            val fragment = LeaveTabFragment()
            val args = Bundle()
            args.putString(ARG_TAB_TYPE, tabType)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString(ARG_TAB_TYPE)
        // Use tabType to customize the fragment's behavior
    }
}