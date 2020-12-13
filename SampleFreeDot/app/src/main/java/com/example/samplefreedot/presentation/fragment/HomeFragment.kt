package com.example.samplefreedot.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplefreedot.R
import com.example.samplefreedot.databinding.FragmentHomeBinding
import com.example.samplefreedot.presentation.activity.CompanyDetailAcitivity
import com.example.samplefreedot.presentation.adapter.HomeDesignerAdapter
import com.example.samplefreedot.presentation.adapter.HomePlannerAdapter
import com.example.samplefreedot.presentation.adapter.HomeProgrammerAdapter
import com.example.samplefreedot.presentation.model.DesignerData
import com.example.samplefreedot.presentation.model.PlannerData
import com.example.samplefreedot.presentation.model.ProgrammerData

class HomeFragment : Fragment(), HomeProgrammerAdapter.OnItemClickListener,
    HomePlannerAdapter.OnItemClickListener, HomeDesignerAdapter.OnItemClickListener {

    private lateinit var programmerAdapter: HomeProgrammerAdapter
    private lateinit var designerAdapter: HomeDesignerAdapter
    private lateinit var plannerAdapter: HomePlannerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        programmerAdapter = HomeProgrammerAdapter(this) // 각각의 OnItemClickListener를 참조받음
        designerAdapter = HomeDesignerAdapter(this)
        plannerAdapter = HomePlannerAdapter(this)
        setAdapterData()
        setRecyclerView(binding)
        return binding.root
    }

    private fun setAdapterData() {
        programmerAdapter.programmerData = mutableListOf(
            ProgrammerData("구골"),
            ProgrammerData("아마잔"),
            ProgrammerData("ProgrammerData3"),
            ProgrammerData("ProgrammerData4"),
            ProgrammerData("ProgrammerData5"),
            ProgrammerData("ProgrammerData6"),
            ProgrammerData("ProgrammerData7")
        )
        programmerAdapter.notifyDataSetChanged()

        designerAdapter.designerData = mutableListOf(
            DesignerData("애팔"),
            DesignerData("넥손"),
            DesignerData("DesignerData3"),
            DesignerData("DesignerData4"),
            DesignerData("DesignerData5"),
            DesignerData("DesignerData6"),
            DesignerData("DesignerData7")
        )
        designerAdapter.notifyDataSetChanged()

        plannerAdapter.plannerData = mutableListOf(
            PlannerData("NB소프트"),
            PlannerData("ES스포츠"),
            PlannerData("PlannerData3"),
            PlannerData("PlannerData4"),
            PlannerData("PlannerData5"),
            PlannerData("PlannerData6"),
            PlannerData("PlannerData7")
        )
    }

    private fun setRecyclerView(binding: FragmentHomeBinding) {
        binding.homeProgrammerListView.apply {
            adapter = programmerAdapter
            layoutManager = LinearLayoutManager(requireContext()).also {
                it.orientation = LinearLayoutManager.HORIZONTAL
            }

        }
        binding.homeDesignerListView.apply {
            adapter = designerAdapter
            layoutManager = LinearLayoutManager(requireContext()).also {
                it.orientation = LinearLayoutManager.HORIZONTAL
            }
        }
        binding.homePlannerListView.apply {
            adapter = plannerAdapter
            layoutManager = LinearLayoutManager(requireContext()).also {
                it.orientation = LinearLayoutManager.HORIZONTAL
            }
        }
    }

    // Programmer Data Click event
    override fun onItemClicked(programmerData: ProgrammerData) {
        val intent = Intent(requireContext(),CompanyDetailAcitivity::class.java)
        intent.putExtra("companyName",programmerData.text)
        startActivity(intent)
    }

    // Planner Data Click event
    override fun onItemClicked(plannerData: PlannerData) {
        Toast.makeText(requireContext(), plannerData.text, Toast.LENGTH_SHORT).show()
    }

    // Designer Data Click event
    override fun onItemClick(designerData: DesignerData) {
        Toast.makeText(requireContext(),designerData.text,Toast.LENGTH_SHORT).show()
    }

}