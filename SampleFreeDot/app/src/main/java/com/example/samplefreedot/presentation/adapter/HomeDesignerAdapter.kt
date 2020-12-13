package com.example.samplefreedot.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.samplefreedot.R
import com.example.samplefreedot.databinding.ItemHomeDesignerBinding
import com.example.samplefreedot.presentation.model.DesignerData

class HomeDesignerAdapter(
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<HomeDesignerAdapter.HomeDesignViewHolder>() {
    var designerData = mutableListOf<DesignerData>()
    inner class HomeDesignViewHolder(private val binding: ItemHomeDesignerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data : DesignerData) {
            binding.apply {
                designerData = data
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeDesignerAdapter.HomeDesignViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemHomeDesignerBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_home_designer, parent, false)
        return HomeDesignViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeDesignerAdapter.HomeDesignViewHolder, position: Int) {
        holder.bind(designerData[position])
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(designerData[position])
        }
    }

    override fun getItemCount(): Int = designerData.size

    interface OnItemClickListener {
        fun onItemClick(designerData: DesignerData)
    }
}