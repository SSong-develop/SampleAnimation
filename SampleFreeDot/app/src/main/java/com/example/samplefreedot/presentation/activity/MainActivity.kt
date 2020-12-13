package com.example.samplefreedot.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.example.samplefreedot.R
import com.example.samplefreedot.databinding.ActivityMainBinding
import com.example.samplefreedot.presentation.adapter.MainViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewPagerAdapter : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        setViewPager(binding)
        setTab(binding)
    }

    private fun setTab(binding: ActivityMainBinding) {
        binding.mainTab.apply {
            setupWithViewPager(binding.mainViewpager)
            getTabAt(0)?.text = "홈"
            getTabAt(1)?.text = "프로필"
            getTabAt(2)?.text = "지원확인"
        }
    }

    private fun setViewPager(binding: ActivityMainBinding) {
        binding.mainViewpager.apply {
            adapter = mainViewPagerAdapter
        }
    }


}