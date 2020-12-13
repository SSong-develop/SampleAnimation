package com.example.samplefreedot.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.samplefreedot.R
import com.example.samplefreedot.databinding.ItemHomePlannerBinding
import com.example.samplefreedot.presentation.model.PlannerData

class HomePlannerAdapter(
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<HomePlannerAdapter.HomePlannerViewHolder>() {
    var plannerData = mutableListOf<PlannerData>()

    inner class HomePlannerViewHolder(private val binding: ItemHomePlannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data : PlannerData){
            binding.apply {
                plannerData = data
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePlannerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemHomePlannerBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_home_planner, parent, false)
        return HomePlannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomePlannerViewHolder, position: Int) {
        holder.bind(plannerData[position])
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClicked(plannerData[position])
        }
    }

    override fun getItemCount(): Int = plannerData.size

    interface OnItemClickListener {
        fun onItemClicked(plannerData: PlannerData)
    }

}