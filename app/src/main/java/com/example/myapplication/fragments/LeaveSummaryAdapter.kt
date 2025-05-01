package com.example.myapplication.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLeaveSummaryBinding

class LeaveSummaryAdapter(
    private val onItemClick: (LeaveSummaryItem) -> Unit
) : ListAdapter<LeaveSummaryItem, LeaveSummaryAdapter.LeaveSummaryViewHolder>(LeaveSummaryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaveSummaryViewHolder {
        val binding = ItemLeaveSummaryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LeaveSummaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LeaveSummaryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class LeaveSummaryViewHolder(private val binding: ItemLeaveSummaryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(getItem(position))
                }
            }
        }

        fun bind(item: LeaveSummaryItem) {
            binding.apply {
                leaveType.text = item.leaveType
                leaveStatus.text = item.leaveStatus
                leaveDates.text = item.leaveDates
            }
        }
    }
}

class LeaveSummaryDiffCallback : DiffUtil.ItemCallback<LeaveSummaryItem>() {
    override fun areItemsTheSame(oldItem: LeaveSummaryItem, newItem: LeaveSummaryItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LeaveSummaryItem, newItem: LeaveSummaryItem): Boolean {
        return oldItem == newItem
    }
}

data class LeaveSummaryItem(
    val id: Long,
    val leaveType: String,
    val leaveStatus: String,
    val leaveDates: String
)