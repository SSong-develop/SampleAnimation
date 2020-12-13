package com.example.samplefreedot.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.samplefreedot.R
import com.example.samplefreedot.databinding.ItemProfileBinding
import com.example.samplefreedot.databinding.ItemProfileListBinding
import com.example.samplefreedot.presentation.model.ProfileItemData
import com.example.samplefreedot.presentation.model.UserSpec

class ProfileAdapter(private val context: Context) :
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    var data = mutableListOf<ProfileItemData>()

    inner class ProfileViewHolder(private val binding: ItemProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val profileItemAdapter = ProfileItemAdapter()
        fun bind(userData: ProfileItemData) {
            binding.apply {
                profileItemData = userData
                profileItemAdapter.data = userData.userSpecList as MutableList<UserSpec>
                profileItemAdapter.notifyDataSetChanged()
            }
            binding.profileItemSave.setOnClickListener {
                profileItemAdapter.data.add(UserSpec(binding.profileItemEditText.text.toString()))
                profileItemAdapter.notifyDataSetChanged()
            }
            binding.profileItemListView.apply {
                adapter = profileItemAdapter
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(DividerItemDecoration(context,LinearLayoutManager.VERTICAL))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemProfileBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_profile, parent, false)
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}

class ProfileItemAdapter : RecyclerView.Adapter<ProfileItemAdapter.ProfileItemViewHolder>() {
    var data = mutableListOf<UserSpec>()

    inner class ProfileItemViewHolder(private val binding: ItemProfileListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userSpecList: UserSpec) {
            binding.apply {
                userSpec = userSpecList
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemProfileListBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_profile_list, parent, false)
        return ProfileItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}