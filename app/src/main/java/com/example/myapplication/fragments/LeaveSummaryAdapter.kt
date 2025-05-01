package com.example.myapplication.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLeaveSummaryBinding

class LeaveSummaryAdapter(
    private val items: List<LeaveSummaryItem>
) : RecyclerView.Adapter<LeaveSummaryAdapter.LeaveSummaryViewHolder>() {

    inner class LeaveSummaryViewHolder(private val binding: ItemLeaveSummaryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LeaveSummaryItem) {
            binding.leaveType.text = item.leaveType
            binding.leaveStatus.text = item.leaveStatus
            binding.leaveDates.text = item.leaveDates
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaveSummaryViewHolder {
        val binding = ItemLeaveSummaryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LeaveSummaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LeaveSummaryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

data class LeaveSummaryItem(
    val leaveType: String,
    val leaveStatus: String,
    val leaveDates: String
)