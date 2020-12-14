package com.example.sampleviewpagerpagetransformer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sampleviewpagerpagetransformer.R

const val BACKGROUND_COLOR = "backgroundColor"
const val PAGE = "page"

class IntroFragment : Fragment() {

    private var mBackgroundColor: Int? = null
    private var mPage: Int? = null

    companion object {
        fun newInstance(backgroundColor: Int, page: Int): IntroFragment {
            val frag = IntroFragment()
            val bundle = Bundle()
            bundle.putInt(BACKGROUND_COLOR, backgroundColor)
            bundle.putInt(PAGE, page)
            frag.arguments = bundle
            return frag
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBackgroundColor = arguments?.getInt(BACKGROUND_COLOR)
        mPage = arguments?.getInt(PAGE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Select a layout based on the current page
        val view =
            if (mPage == 0) inflater.inflate(
                R.layout.fragment_intro,
                container,
                false
            ) else inflater.inflate(R.layout.fragment_second_intro, container, false)
        view.tag = mPage
        return view
    }

    fun getBackgroundColor(): Int? = mBackgroundColor


}