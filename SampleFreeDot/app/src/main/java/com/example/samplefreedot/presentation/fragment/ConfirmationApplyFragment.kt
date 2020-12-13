package com.example.samplefreedot.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.cleveroad.fanlayoutmanager.FanLayoutManager
import com.cleveroad.fanlayoutmanager.FanLayoutManagerSettings
import com.example.samplefreedot.R
import com.example.samplefreedot.databinding.FragmentConfirmationApplyBinding
import com.example.samplefreedot.presentation.adapter.ConfirmationApplyAdapter
import com.example.samplefreedot.presentation.model.ConfirmationApplyData

class ConfirmationApplyFragment : Fragment() {

    private lateinit var confirmationApplyAdapter: ConfirmationApplyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentConfirmationApplyBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_confirmation_apply,
            container,
            false
        )
        confirmationApplyAdapter = ConfirmationApplyAdapter()
        setAdapterData()
        setAdapter(binding)
        return binding.root
    }

    private fun setAdapterData() {
        confirmationApplyAdapter.data = mutableListOf(
            ConfirmationApplyData("구골","(2020.12.07)"),
            ConfirmationApplyData("아마잔","(2020.12.01)"),
            ConfirmationApplyData("애팔","(2020.11.05)"),
            ConfirmationApplyData("넥손","(2020.11.21)"),
            ConfirmationApplyData("NB소프트","(2020.11.25)"),
            ConfirmationApplyData("ES스포츠","(2020.11.08)"),
            ConfirmationApplyData("로이엇","(2020.11.02)"),
        )
        confirmationApplyAdapter.notifyDataSetChanged()
    }

    private fun setAdapter(binding: FragmentConfirmationApplyBinding) {
        val fanLayoutManager = FanLayoutManagerSettings
            .newBuilder(requireContext())
            .withFanRadius(true)
            .withAngleItemBounce(5F)
            .withViewWidthDp(120F)
            .withViewHeightDp(160F)
            .build()

        binding.confirmationListView.apply {
            adapter = confirmationApplyAdapter
            layoutManager = FanLayoutManager(requireContext(),fanLayoutManager)
            addItemDecoration(DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL))
        }
    }

}