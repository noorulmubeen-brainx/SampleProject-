package com.brainXTech.sampleapplevelup.activity.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.databinding.DataBindingUtil
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.ApplicationConstants
import com.brainXTech.sampleapplevelup.adapters.HomePageAdapter
import com.brainXTech.sampleapplevelup.customViews.CustomDialogue
import com.brainXTech.sampleapplevelup.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
    }

    private fun setDialogue() {
        val dialog = CustomDialogue(R.layout.dialogue_box_password_change, this)
        dialog.show()
        val timer = object : CountDownTimer(5000, 5000) {
            override fun onTick(millisUntilFinished: Long) {

            }
            override fun onFinish() {
                dialog.dismiss()

            }
        }
        timer.start()
    }

    private fun setBinding() {
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val showDialogue =
            intent.getBooleanExtra(ApplicationConstants.SHOW_CHANGE_PASSWORD_DIALOGUE, false)
        if (showDialogue)
            setDialogue()
        homeViewPager.adapter=HomePageAdapter(supportFragmentManager)


    }
}