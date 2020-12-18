package com.brainXTech.sampleapplevelup.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.brainXTech.sampleapplevelup.fragments.onBaording.OnBoardingFirstFragment

class OnBoardingPageAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
        return 3
    }



    override fun createFragment(position: Int): Fragment {
//        TODO("Not yet implemented")

        return OnBoardingFirstFragment(position)
    }
}