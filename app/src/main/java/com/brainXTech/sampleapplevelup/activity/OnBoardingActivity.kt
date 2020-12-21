package com.brainXTech.sampleapplevelup.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.adapters.OnBoardingPageAdapter
import com.brainXTech.sampleapplevelup.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : FragmentActivity(),View.OnClickListener, ViewPager.OnPageChangeListener{
    private lateinit var onBoardingBinding: ActivityOnBoardingBinding
    private lateinit var viewPager2: ViewPager
    private lateinit var pagerAdapter:OnBoardingPageAdapter
    private  lateinit var firstDot:ImageView
    private  lateinit var secondDot:ImageView
    private  lateinit var thirdDot:ImageView
    private lateinit var skipButton: Button


    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBindings()
        setListeners()

    }

    private fun setListeners() {
        viewPager2.addOnPageChangeListener(this)
        skipButton.setOnClickListener(this)
        firstDot.setOnClickListener(this)
        secondDot.setOnClickListener(this)
        thirdDot.setOnClickListener(this)
    }

    private fun setBindings() {
        onBoardingBinding=DataBindingUtil.setContentView(this,R.layout.activity_on_boarding)
        viewPager2=onBoardingBinding.onBoardingViewPager
        pagerAdapter=OnBoardingPageAdapter(supportFragmentManager)
        viewPager2.adapter=pagerAdapter
        firstDot=onBoardingBinding.firstDot
        secondDot=onBoardingBinding.secondDot
        thirdDot=onBoardingBinding.thirdDot
        skipButton=onBoardingBinding.skipButton
    }

    fun setSelectedDot(position: Int) {
        when(position){
            0-> firstDot.setBackgroundResource(R.drawable.ic_selected_bottom_point)
            1->secondDot.setBackgroundResource(R.drawable.ic_selected_bottom_point)
            2->thirdDot.setBackgroundResource(R.drawable.ic_selected_bottom_point)
        }
    }

    fun resetDotsSource(position: Int) {
        onBoardingBinding.firstDot.setBackgroundResource(R.drawable.ic_not_selected_bottom_point)
        onBoardingBinding.secondDot.setBackgroundResource(R.drawable.ic_not_selected_bottom_point)
        onBoardingBinding.thirdDot.setBackgroundResource(R.drawable.ic_not_selected_bottom_point)
        setSelectedDot(position)
    }

//     private val onPageChange=object : ViewPager2.OnPageChangeCallback() {
//        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//            super.onPageScrolled(position, positionOffset, positionOffsetPixels)
//        }
//        override fun onPageSelected(position: Int) {
//            super.onPageSelected(position)
//            firstDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
//            secondDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
//            thirdDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
////            resetDotsSource(position)
//            when(position){
//                0-> firstDot.setImageResource(R.drawable.ic_selected_bottom_point)
//                1->secondDot.setImageResource(R.drawable.ic_selected_bottom_point)
//                2->thirdDot.setImageResource(R.drawable.ic_selected_bottom_point)
//            }
//
//        }
//        override fun onPageScrollStateChanged(state: Int) {
//            super.onPageScrollStateChanged(state)
//        }
//    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//        TODO("Not yet implemented")
//        super.onPage(position, positionOffset, positionOffsetPixels)
    }

    override fun onPageSelected(position: Int) {
        resetDotsSource(position)

//        TODO("Not yet implemented")
    }

    override fun onPageScrollStateChanged(state: Int) {
//        TODO("Not yet implemented")
    }

}

