package com.brainXTech.sampleapplevelup.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.adapters.OnBoardingPageAdapter
import com.brainXTech.sampleapplevelup.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : FragmentActivity() {
    private lateinit var onBoardingBinding: ActivityOnBoardingBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var pagerAdapter:OnBoardingPageAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoardingBinding=DataBindingUtil.setContentView(this,R.layout.activity_on_boarding)
        viewPager2=onBoardingBinding.onBoardingViewPager
        pagerAdapter=OnBoardingPageAdapter(this)
        viewPager2.adapter=pagerAdapter


        setContentView(R.layout.activity_on_boarding)
    }
}