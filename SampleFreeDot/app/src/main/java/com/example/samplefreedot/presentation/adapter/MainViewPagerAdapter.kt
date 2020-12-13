package com.example.samplefreedot.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.samplefreedot.presentation.fragment.ConfirmationApplyFragment
import com.example.samplefreedot.presentation.fragment.HomeFragment
import com.example.samplefreedot.presentation.fragment.ProfileFragment

class MainViewPagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> ProfileFragment()
            else -> ConfirmationApplyFragment()
        }
    }
}