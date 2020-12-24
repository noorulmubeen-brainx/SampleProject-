package com.brainXTech.sampleapplevelup.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.brainXTech.sampleapplevelup.fragments.dashBoard.HomeFragment
import com.brainXTech.sampleapplevelup.fragments.onBaording.OnBoardingFirstFragment

class HomePageAdapter(fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)  {

    //region properties
    private lateinit var fragmentList: List<Fragment>
    private lateinit var titleList: List<String>
    //endregion




    override fun getItem(position: Int): Fragment =fragmentList[position]

    override fun getCount(): Int =fragmentList.size

    override fun getPageTitle(position: Int): CharSequence =
        if (titleList.size > position) titleList[position] else ""

    fun addFragments(fragments:List<Fragment>,titles:List<String>){
        fragmentList = fragments
        titleList = titles
    }



}