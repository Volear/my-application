package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LeaveAdapter(private val leaveList: List<String>) : RecyclerView.Adapter<LeaveAdapter.LeaveViewHolder>() {

    class LeaveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val leaveText: TextView = itemView.findViewById(R.id.leave_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaveViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_leave, parent, false)
        return LeaveViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeaveViewHolder, position: Int) {
        holder.leaveText.text = leaveList[position]
    }

    override fun getItemCount(): Int {
        return leaveList.size
    }
}