package com.example.samplefreedot.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplefreedot.R
import com.example.samplefreedot.databinding.FragmentProfileBinding
import com.example.samplefreedot.presentation.adapter.ProfileAdapter
import com.example.samplefreedot.presentation.model.ProfileItemData
import com.example.samplefreedot.presentation.model.UserSpec

class ProfileFragment : Fragment() {

    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentProfileBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false)
        val userSpecList : List<UserSpec> = mutableListOf(
            UserSpec("SampleData")
        )
        profileAdapter = ProfileAdapter(requireContext())
        setAdapterData(userSpecList)
        setAdapter(binding)
        return binding.root
    }

    private fun setAdapterData(userSpecList: List<UserSpec>) {
        profileAdapter.data = mutableListOf(
            ProfileItemData("성장배경",userSpecList),
            ProfileItemData("성격 및 재능",userSpecList),
            ProfileItemData("전공 및 경력사항",userSpecList),
            ProfileItemData("지원동기 및 포부",userSpecList),
            ProfileItemData("경력사항",userSpecList),
            ProfileItemData("학력사항",userSpecList),
            ProfileItemData("자격증",userSpecList),
            ProfileItemData("연락처",userSpecList)

        )
        profileAdapter.notifyDataSetChanged()
    }

    private fun setAdapter(binding: FragmentProfileBinding) {
        binding.profileListView.apply {
            adapter = profileAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL))
        }
    }

}