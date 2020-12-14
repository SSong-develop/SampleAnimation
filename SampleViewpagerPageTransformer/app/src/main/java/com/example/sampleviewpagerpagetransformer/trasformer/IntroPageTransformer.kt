package com.example.sampleviewpagerpagetransformer.trasformer

import android.animation.ArgbEvaluator
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.sampleviewpagerpagetransformer.adapter.MainAdapter
import kotlinx.android.synthetic.main.fragment_intro.view.*
import kotlin.math.abs

class IntroPageTransformer(private var viewPager: ViewPager) : ViewPager.PageTransformer,
    ViewPager.OnPageChangeListener {

    private val argbEvaluator: ArgbEvaluator
    private var color: Int = -1

    init {
        viewPager.addOnPageChangeListener(this)
        argbEvaluator = ArgbEvaluator()
    }

    override fun transformPage(page: View, position: Float) {
        parallaxAnimation(page , position)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        color =
            argbEvaluator.evaluate(
                positionOffset,
                (viewPager.adapter as MainAdapter).getFragmentBackgroundColor(position),
                (viewPager.adapter as MainAdapter).getFragmentBackgroundColor(position + 1)
            ) as Int
        viewPager.setBackgroundColor(color)
    }

    override fun onPageSelected(position: Int) {
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    private fun parallaxAnimation(page : View, position : Float){
        val pagePosition = page.tag
        val pageWidth = page.width
        val pageWidthTimesPosition = pageWidth * position
        val absPosition = abs(position)

        if (position < 0) { // position == -1
            // This page is way off-screen to the left
            page.title.alpha = 1.0f - absPosition
            page.title.translationX = -pageWidthTimesPosition * 0.92f
            page.des.alpha = 1.0f - absPosition
            page.des.translationX = -pageWidthTimesPosition * 0.92f
        } else {
            page.title.alpha = 1.0f - absPosition
            page.title.translationX = -pageWidthTimesPosition
            page.des.alpha = 1.0f - absPosition
            page.des.translationX = -pageWidthTimesPosition
        }
    }

    // SSong-develop test Animation
    private fun testParallaxAnimation(page : View , position : Float){
        val pagePosition = page.tag
        val pageWidth = page.width
        val pageWidthTimesPosition = pageWidth * position
        val absPosition = abs(position)

        if(position <= 1.0f || position >= 1.0f){
            page.title.alpha = 1.0f - absPosition
            page.des.translationY = -pageWidthTimesPosition / 2f
            page.des.alpha = 1.0f - absPosition
            page.des.translationY = -pageWidthTimesPosition / 2f
        } else if(position == 0.0f){
            // i think , this sector isn't useful
        } else {
            page.title.alpha = 1.0f - absPosition
            page.des.translationY = -pageWidthTimesPosition / 2f
            page.des.alpha = 1.0f - absPosition
            page.des.translationY = -pageWidthTimesPosition / 2f
        }
    }

    private fun depthPageTransformAnimation(page : View, position : Float){
        val MIN_SCALE = 0.75f
        page.apply{
            val pageWidth = width
            when {
                position < -1 -> { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    alpha = 0f
                }
                position <= 0 -> { // [-1,0]
                    // Use the default slide transition when moving to the left page
                    alpha = 1f
                    translationX = 0f
                    scaleX = 1f
                    scaleY = 1f
                }
                position <= 1 -> { // (0,1]
                    // Fade the page out.
                    alpha = 1 - position

                    // Counteract the default slide transition
                    translationX = pageWidth * -position

                    // Scale the page down (between MIN_SCALE and 1)
                    val scaleFactor = (MIN_SCALE + (1 - MIN_SCALE) * (1 - abs(position)))
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                }
                else -> { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    alpha = 0f
                }
            }
        }
    }
}