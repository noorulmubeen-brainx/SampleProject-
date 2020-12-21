package com.brainXTech.sampleapplevelup.fragments.onBaording

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.databinding.OnBoardingFragmentBinding

class OnBoardingFirstFragment(private val currentIndex:Int) : Fragment() {
    private lateinit var onBoardingBinding: OnBoardingFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        onBoardingBinding=DataBindingUtil.inflate(inflater,R.layout.on_boarding_fragment, container, false)
        return onBoardingBinding.root
    }


    override fun onStart() {
        super.onStart()

        when(currentIndex){
            0->setFirstOnBoarding()
            1->setSecondOnBoarding()
            2->setThirdOnBoarding()
        }
//        resetDotsSource()
//        setSelectedDot()


    }

    private fun setThirdOnBoarding() {
//        TODO("Not yet implemented")
        onBoardingBinding.imageView.setBackgroundResource(R.drawable.ic_third_onboarding_fragment)
        onBoardingBinding.headingText.text=getString(R.string.third_on_boarding_heading)
    }

    private fun setSecondOnBoarding() {
//        TODO("Not yet implemented")
        onBoardingBinding.imageView.setBackgroundResource(R.drawable.ic_second_onboarding_fragment)
        onBoardingBinding.headingText.text=getString(R.string.second_onboarding_screen_heading)
    }

    private fun setFirstOnBoarding() {
        onBoardingBinding.imageView.setBackgroundResource(R.drawable.on_board_first_screen_image)
        onBoardingBinding.headingText.text=getString(R.string.first_onboarding_heading)
//        TODO("Not yet implemented")
    }
}