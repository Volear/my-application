package com.example.myapplication.fragments

import java.util.Date

data class NotificationItem(
    val id: String,
    val title: String,
    val description: String,
    val timestamp: Date = Date(),
    val isRead: Boolean = false
)