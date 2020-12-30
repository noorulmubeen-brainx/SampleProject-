package com.brainXTech.sampleapplevelup.fragments.onBaording

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.databinding.OnBoardingFragmentBinding
import kotlinx.android.synthetic.main.on_boarding_fragment.*

class OnBoardingFirstFragment(private val currentIndex: Int) : Fragment() {
    //    region properties
    private lateinit var onBoardingBinding: OnBoardingFragmentBinding
//endregion


    //    region lifecycle
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        onBoardingBinding =
            DataBindingUtil.inflate(inflater, R.layout.on_boarding_fragment, container, false)
        return onBoardingBinding.root
    }


    override fun onStart() {
        super.onStart()

        when (currentIndex) {
            0 -> setOnBoarding(
                R.drawable.on_board_first_screen_image,
                getString(R.string.first_onboarding_heading)
            )
            1 -> setOnBoarding(
                R.drawable.ic_second_onboarding_fragment,
                getString(R.string.second_onboarding_screen_heading)
            )
            2 -> setOnBoarding(
                R.drawable.ic_third_onboarding_fragment,
                getString(R.string.third_on_boarding_heading)
            )
        }


    }


    //    endregion

//    region Private method

    private fun setOnBoarding(fragmentImage: Int, string: String) {
        imageView.setBackgroundResource(fragmentImage)
        headingText.text = string
    }
//    endregion


}