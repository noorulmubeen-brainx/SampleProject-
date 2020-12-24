package com.brainXTech.sampleapplevelup.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.brainXTech.sampleapplevelup.fragments.dashBoard.HomeFragment
import com.brainXTech.sampleapplevelup.fragments.onBaording.OnBoardingFirstFragment

class HomePageAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)  {

    override fun getItem(position: Int): Fragment {
        return HomeFragment()
    }

    override fun getCount(): Int {
        return 3
    }



}