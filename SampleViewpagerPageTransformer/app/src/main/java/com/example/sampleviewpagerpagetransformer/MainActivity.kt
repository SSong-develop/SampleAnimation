package com.example.sampleviewpagerpagetransformer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleviewpagerpagetransformer.adapter.MainAdapter
import com.example.sampleviewpagerpagetransformer.trasformer.IntroPageTransformer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_viewpager.adapter = MainAdapter(supportFragmentManager)
        main_viewpager.setPageTransformer(false,IntroPageTransformer(main_viewpager))
    }
}