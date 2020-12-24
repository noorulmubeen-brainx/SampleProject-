package com.brainXTech.sampleapplevelup.activity.dashboard

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.ApplicationConstants
import com.brainXTech.sampleapplevelup.adapters.HomePageAdapter
import com.brainXTech.sampleapplevelup.customViews.CustomDialogue
import com.brainXTech.sampleapplevelup.databinding.ActivityHomeBinding
import com.brainXTech.sampleapplevelup.fragments.dashBoard.HomeFragment
import com.brainXTech.sampleapplevelup.fragments.dashBoard.NotificationFragment
import com.brainXTech.sampleapplevelup.fragments.dashBoard.SettingsFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.home_tab_layout.view.*

class
HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding
    private var fragmentList: MutableList<Fragment> = mutableListOf()
    private val fragmentsTitles: MutableList<String> = mutableListOf()
    private val tabIcons: MutableList<Int> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        populateFragments()
        showDialog()
        setViewPagerAdapter()
        setTabChangeListener()
    }

    private fun setTabChangeListener() {
        homeTabLayout.addOnTabSelectedListener(homeTabListener)
    }

    private val homeTabListener =object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            when(tab?.position){
                0-> setActiveTab(tab,R.drawable.ic_home_selected)
                1->setActiveTab(tab,R.drawable.ic_notification_selected)
                2->setActiveTab(tab,R.drawable.ic_settings_selected)
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {
            when(tab?.position){
                0-> setDeActivateTab(tab,R.drawable.ic_home_not_selected)
                1->setDeActivateTab(tab,R.drawable.ic_notification_not_selected)
                2->setDeActivateTab(tab,R.drawable.ic_settings_not_selected)
            }
        }

        override fun onTabReselected(tab: TabLayout.Tab?) {
        }
    }

    private fun setDeActivateTab(tab: TabLayout.Tab, imageResource: Int) {
        tab.customView?.home_tab_layout_icon?.setImageResource(imageResource)
        tab.customView?.home_tab_layout_title?.setTypeface(null,Typeface.NORMAL)
        tab.customView?.home_tab_layout_title?.setTextColor(Color.GRAY)
    }

    private fun setActiveTab(tab: TabLayout.Tab, imageResource: Int) {
        tab.customView?.home_tab_layout_icon?.setImageResource(imageResource)
        tab.customView?.home_tab_layout_title?.setTypeface(null,Typeface.BOLD)
        tab.customView?.home_tab_layout_title?.setTextColor(Color.BLACK)
    }

    private fun populateFragments() {
        fragmentsTitles.clear()
        fragmentList.clear()
        tabIcons.clear()
        fragmentList.add(HomeFragment())
        fragmentsTitles.add(getString(R.string.home))
        fragmentList.add(NotificationFragment())
        fragmentsTitles.add(getString(R.string.notiification))
        fragmentList.add(SettingsFragment())
        fragmentsTitles.add(getString(R.string.settings))
        tabIcons.add(R.drawable.ic_home_selected)
        tabIcons.add(R.drawable.ic_notification_not_selected)
        tabIcons.add(R.drawable.ic_settings_not_selected)



    }

    private fun showDialog() {
        val showDialogue =
            intent.getBooleanExtra(ApplicationConstants.SHOW_CHANGE_PASSWORD_DIALOGUE, false)
        if (showDialogue)
            setDialogue()
    }

    private fun setDialogue() {
        val dialog = CustomDialogue(R.layout.dialogue_box_password_change, this)
        dialog.show()
        val timer = object : CountDownTimer(5000, 5000) {
            override fun onTick(millisUntilFinished: Long)= Unit

            override fun onFinish() {
                dialog.dismiss()

            }
        }
        timer.start()
    }

    private fun setBinding() {
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)


    }

    private fun setViewPagerAdapter() {
        homeViewPager.offscreenPageLimit = 3
        val myAdapter:HomePageAdapter = HomePageAdapter(supportFragmentManager)
        myAdapter.apply {
            addFragments(fragmentList,fragmentsTitles)
            homeViewPager.adapter=this
            homeTabLayout.setupWithViewPager(homeViewPager)
        }
        setTabIcons()
    }

    private fun setTabIcons() {
        (0 until homeTabLayout.tabCount).forEach { i ->
            homeTabLayout.getTabAt(i)?.apply {
                setCustomView(R.layout.home_tab_layout)
                customView?.home_tab_layout_icon?.setImageResource(tabIcons[i])
                customView?.home_tab_layout_title?.text = fragmentsTitles[i]
                if (this.isSelected) {
                    customView?.home_tab_layout_title?.setTypeface(null, Typeface.BOLD)
                    customView?.home_tab_layout_title?.setTextColor(Color.BLACK)
                }
            }
        }
    }

}

