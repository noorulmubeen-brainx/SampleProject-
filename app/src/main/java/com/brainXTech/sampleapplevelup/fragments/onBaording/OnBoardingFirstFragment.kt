package com.brainXTech.sampleapplevelup.fragments.onBaording

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.databinding.OnBoardingFragmentBinding

class OnBoardingFirstFragment(private val currentIndex: Int) : Fragment() {
    //    region properties
    private lateinit var onBoardingBinding: OnBoardingFragmentBinding
    private lateinit var imageView: ImageView
    private lateinit var headingText: TextView
//endregion


    //    region lifecycle
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        onBoardingBinding =
            DataBindingUtil.inflate(inflater, R.layout.on_boarding_fragment, container, false)
        imageView = onBoardingBinding.imageView
        headingText = onBoardingBinding.headingText
        return onBoardingBinding.root
    }


    override fun onStart() {
        super.onStart()

        when (currentIndex) {
            0 -> setFirstOnBoarding()
            1 -> setSecondOnBoarding()
            2 -> setThirdOnBoarding()
        }


    }


    //    endregion

//    region Private method
    private fun setThirdOnBoarding() {
        imageView.setBackgroundResource(R.drawable.ic_third_onboarding_fragment)
        headingText.text = getString(R.string.third_on_boarding_heading)
    }

    private fun setSecondOnBoarding() {
        imageView.setBackgroundResource(R.drawable.ic_second_onboarding_fragment)
        headingText.text = getString(R.string.second_onboarding_screen_heading)
    }

    private fun setFirstOnBoarding() {
        imageView.setBackgroundResource(R.drawable.on_board_first_screen_image)
        headingText.text = getString(R.string.first_onboarding_heading)
    }
//    endregion


}