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
        pagerAdapter=OnBoardingPageAdapter(this)
        viewPager2.adapter=pagerAdapter
        viewPager2.registerOnPageChangeCallback(onPageChange)
    }
    fun setSelectedDot(position: Int) {
        when(position){
            0-> onBoardingBinding.firstDot.setImageResource(R.drawable.ic_selected_bottom_point)
            1->onBoardingBinding.secondDot.setImageResource(R.drawable.ic_selected_bottom_point)
            2->onBoardingBinding.thirdDot.setImageResource(R.drawable.ic_selected_bottom_point)
        }
    }

    fun resetDotsSource(position: Int) {
        onBoardingBinding.firstDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
        onBoardingBinding.secondDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
        onBoardingBinding.thirdDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
        setSelectedDot(position)
    }

     onPageChange : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels)
        }

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            resetDotsSource(position)

        }
        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
        }

    }

}


//
//object pagerTabListener : TabLayout.OnTabSelectedListener {
//    override fun onTabSelected(tab: TabLayout.Tab?) {
//        tab?.customView?.id?.setImage
//    }
//
//    override fun onTabUnselected(tab: TabLayout.Tab?) {
//        tab?.setCustomView(R.layout.on_boarding_bottom_dots_unfilled)
//    }
//
//    override fun onTabReselected(tab: TabLayout.Tab?) {
////        TODO("Not yet implemented")
//    }
//}
