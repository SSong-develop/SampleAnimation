package com.example.samplefreedot.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.samplefreedot.R
import com.example.samplefreedot.databinding.ItemHomeProgrammerBinding
import com.example.samplefreedot.presentation.model.ProgrammerData

class HomeProgrammerAdapter(
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<HomeProgrammerAdapter.HomeProgrammerViewHolder>() {
    var programmerData = mutableListOf<ProgrammerData>()

    inner class HomeProgrammerViewHolder(private val binding : ItemHomeProgrammerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : ProgrammerData){
            binding.apply {
                programmerData = data
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProgrammerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemHomeProgrammerBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_home_programmer, parent, false)
        return HomeProgrammerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeProgrammerViewHolder, position: Int) {
        holder.bind(programmerData[position])
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClicked(programmerData[position])
        }
    }

    override fun getItemCount(): Int = programmerData.size

    interface OnItemClickListener{
        fun onItemClicked(programmerData: ProgrammerData)
    }
}