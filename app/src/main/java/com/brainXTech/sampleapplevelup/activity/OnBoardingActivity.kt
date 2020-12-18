package com.brainXTech.sampleapplevelup.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.adapters.OnBoardingPageAdapter
import com.brainXTech.sampleapplevelup.databinding.ActivityOnBoardingBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity : FragmentActivity() {
    private lateinit var onBoardingBinding: ActivityOnBoardingBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var pagerAdapter:OnBoardingPageAdapter
    private lateinit var onBoardingTabLayout: TabLayout






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoardingBinding=DataBindingUtil.setContentView(this,R.layout.activity_on_boarding)
        viewPager2=onBoardingBinding.onBoardingViewPager
        onBoardingTabLayout=onBoardingBinding.onBoardingTab
        pagerAdapter=OnBoardingPageAdapter(this)
        viewPager2.adapter=pagerAdapter
        TabLayoutMediator(onBoardingTabLayout, viewPager2) { tab, position ->
//            tab.setCustomView(R.layout.on_boarding_bottom_dots_unfilled)
//            if(tab.isSelected){
//                tab.setCustomView(R.layout.on_boarding_bottom_dots_filled)
//            }
        }.attach()
        onBoardingTabLayout.addOnTabSelectedListener(pagerTabListener)

//        pagerAdapter.on

    }

/*
//    private fun setSelectedDot() {
//        when(currentIndex){
//            0-> onBoardingBinding.firstDot.setImageResource(R.drawable.ic_selected_bottom_point)
//            1->onBoardingBinding.secondDot.setImageResource(R.drawable.ic_selected_bottom_point)
//            2->onBoardingBinding.thirdDot.setImageResource(R.drawable.ic_selected_bottom_point)
//        }
//    }
//
//    private fun resetDotsSource() {
//        onBoardingBinding.firstDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
//        onBoardingBinding.secondDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
//        onBoardingBinding.thirdDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
//        setSelectedDot()
//    }
*/
}

object pagerTabListener : TabLayout.OnTabSelectedListener {
    override fun onTabSelected(tab: TabLayout.Tab?) {
        tab?.setCustomView(R.layout.on_boarding_bottom_dots_filled)
//        TODO("Not yet implemented")
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
//        TODO("Not yet implemented")
        tab?.setCustomView(R.layout.on_boarding_bottom_dots_unfilled)
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
//        TODO("Not yet implemented")
    }
}
