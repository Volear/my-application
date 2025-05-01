package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentNotificationsBinding
import com.google.android.material.snackbar.Snackbar

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!
    private lateinit var notificationAdapter: NotificationAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        loadNotifications()
    }

    private fun setupRecyclerView() {
        notificationAdapter = NotificationAdapter { notification ->
            onNotificationClicked(notification)
        }
        binding.notificationsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = notificationAdapter
        }
    }

    private fun loadNotifications() {
        val sampleNotifications = listOf(
            NotificationItem("1", "New Message", "You have a new message from John"),
            NotificationItem("2", "Meeting Reminder", "Team meeting in 30 minutes"),
            NotificationItem("3", "Update Available", "A new app update is available")
        )
        notificationAdapter.submitList(sampleNotifications)
    }

    private fun onNotificationClicked(notification: NotificationItem) {
        Snackbar.make(binding.root, "Clicked: ${notification.title}", Snackbar.LENGTH_SHORT).show()
        // TODO: Handle notification click (e.g., mark as read, navigate to detail screen)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}