package com.brainXTech.sampleapplevelup.adapters

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.brainXTech.sampleapplevelup.fragments.onBaording.OnBoardingFirstFragment

class OnBoardingPageAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm)  {

    override fun getItem(position: Int): Fragment {
//        TODO("Not yet implemented")
        return OnBoardingFirstFragment(position)
    }

    override fun getCount(): Int {
//        TODO("Not yet implemented")
        return 3;
    }



}