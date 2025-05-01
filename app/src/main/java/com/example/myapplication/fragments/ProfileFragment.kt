package com.example.myapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentProfileBinding
import com.google.android.material.snackbar.Snackbar

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        loadProfileData()
    }

    private fun setupUI() {
        binding.buttonEditProfile.setOnClickListener {
            // TODO: Implement edit profile functionality
            Snackbar.make(binding.root, "Edit Profile clicked", Snackbar.LENGTH_SHORT).show()
        }

        binding.buttonLogout.setOnClickListener {
            // TODO: Implement logout functionality
            Snackbar.make(binding.root, "Logout clicked", Snackbar.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadProfileData() {
        // TODO: Load actual profile data from a data source (e.g., SharedPreferences, Database, or API)
        binding.textViewName.text = "Tinatin Samkharadze"
        binding.textViewEmail.text = "tinatin@example.com"
        binding.textViewPosition.text = "Test Automation Engineer"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}