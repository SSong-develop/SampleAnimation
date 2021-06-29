package com.example.sampleviewpagerpagetransformer.adapter

import android.graphics.Color
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.sampleviewpagerpagetransformer.fragment.IntroFragment

class MainAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private lateinit var frag1 : IntroFragment
    private lateinit var frag2 : IntroFragment

    override fun getCount(): Int = 4

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                frag1 = IntroFragment.newInstance(Color.parseColor("#03A9F4"),position)
                frag1
            }
            else -> {
                frag2 = IntroFragment.newInstance(Color.parseColor("#4CAF50"),position)
                frag2
            }
        }
    }

    fun getFragmentBackgroundColor(position : Int) : Int?{
        return when(position){
            0-> frag1.getBackgroundColor()
            else -> frag2.getBackgroundColor()
        }
    }
}