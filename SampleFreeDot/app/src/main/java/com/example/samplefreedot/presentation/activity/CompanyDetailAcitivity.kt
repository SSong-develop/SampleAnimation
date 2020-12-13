package com.example.samplefreedot.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.samplefreedot.R
import com.example.samplefreedot.databinding.ActivityCompanyDetailAcitivityBinding

class CompanyDetailAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCompanyDetailAcitivityBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_company_detail_acitivity)
    }
}