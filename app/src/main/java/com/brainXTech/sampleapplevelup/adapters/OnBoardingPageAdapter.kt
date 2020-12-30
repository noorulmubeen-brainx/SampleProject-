package com.brainXTech.sampleapplevelup.adapters

import androidx.fragment.app.*
import com.brainXTech.sampleapplevelup.fragments.onBaording.OnBoardingFirstFragment

class OnBoardingPageAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)  {
//region Implemented Methods
    override fun getItem(position: Int): Fragment {
        return OnBoardingFirstFragment(position)
    }

    override fun getCount(): Int {
        return 3
    }

//endregion

}