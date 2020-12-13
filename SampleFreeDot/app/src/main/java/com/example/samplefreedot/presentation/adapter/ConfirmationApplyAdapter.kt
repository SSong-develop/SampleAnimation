package com.example.samplefreedot.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.samplefreedot.R
import com.example.samplefreedot.databinding.ItemConfirmationBinding
import com.example.samplefreedot.databinding.ItemHomeDesignerBinding
import com.example.samplefreedot.presentation.model.ConfirmationApplyData

class ConfirmationApplyAdapter :
    RecyclerView.Adapter<ConfirmationApplyAdapter.ConfirmViewHolder>() {
    var data = mutableListOf<ConfirmationApplyData>()

    inner class ConfirmViewHolder(private val binding: ItemConfirmationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(confirmDataList : ConfirmationApplyData) {
            binding.apply {
                confirmationData = confirmDataList
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConfirmViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemConfirmationBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_confirmation, parent, false)
        return ConfirmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConfirmViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}