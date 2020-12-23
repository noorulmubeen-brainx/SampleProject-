package com.brainXTech.sampleapplevelup.activity.onBoarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.SharedPreferenceHelper
import com.brainXTech.sampleapplevelup.activity.MainActivity
import com.brainXTech.sampleapplevelup.adapters.OnBoardingPageAdapter
import com.brainXTech.sampleapplevelup.databinding.ActivityOnBoardingBinding
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : FragmentActivity(), View.OnClickListener,
    ViewPager.OnPageChangeListener {
    //    region properties
    private lateinit var onBoardingBinding: ActivityOnBoardingBinding
    private lateinit var viewPager2: ViewPager
    private lateinit var pagerAdapter: OnBoardingPageAdapter
    private lateinit var sharedPreference: SharedPreferenceHelper
// endregion


    //region implementedFunction
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        resetDotsSource(position)

    }

    override fun onPageScrollStateChanged(state: Int) {
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.firstDot -> viewPager2.currentItem = 0
            R.id.secondDot -> viewPager2.currentItem = 1
            R.id.thirdDot -> viewPager2.currentItem = 2
            R.id.skipButton -> {
                sharedPreference.setIfFirstTime(false)
                moveToLogin()

            }

        }
    }



//    endregion

    //    region lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBindings()
        setLocalVariables()
        setListeners()

    }


//    endregion

//    region private Method

    private fun setListeners() {
        viewPager2.addOnPageChangeListener(this)
        skipButton.setOnClickListener(this)
        firstDot.setOnClickListener(this)
        secondDot.setOnClickListener(this)
        thirdDot.setOnClickListener(this)
    }

    private fun moveToLogin() {
        finish()
    }


    private fun setLocalVariables() {
        sharedPreference=SharedPreferenceHelper().also {
            it.setSharedPreference(applicationContext)
        }
    }

    private fun setBindings() {
        onBoardingBinding = DataBindingUtil.setContentView(this, R.layout.activity_on_boarding)
        viewPager2 = onBoardingBinding.onBoardingViewPager
        pagerAdapter = OnBoardingPageAdapter(supportFragmentManager)
        viewPager2.adapter = pagerAdapter

    }

    private fun setSelectedDot(position: Int) {
        when (position) {
            0 -> firstDot.setBackgroundResource(R.drawable.ic_selected_bottom_point)
            1 -> secondDot.setBackgroundResource(R.drawable.ic_selected_bottom_point)
            2 -> thirdDot.setBackgroundResource(R.drawable.ic_selected_bottom_point)
        }
    }

    private fun resetDotsSource(position: Int) {
        firstDot.setBackgroundResource(R.drawable.ic_not_selected_bottom_point)
        secondDot.setBackgroundResource(R.drawable.ic_not_selected_bottom_point)
        thirdDot.setBackgroundResource(R.drawable.ic_not_selected_bottom_point)
        setSelectedDot(position)
    }
// endregion
}

