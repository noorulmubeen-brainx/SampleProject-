package com.brainXTech.sampleapplevelup.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.SharedPreferenceHelper
import com.brainXTech.sampleapplevelup.Utils.UtilFunction
import com.brainXTech.sampleapplevelup.activity.dashboard.HomeActivity
import com.brainXTech.sampleapplevelup.activity.login.FirstTimePasswordActivity
import com.brainXTech.sampleapplevelup.activity.login.LoginActivity
import com.brainXTech.sampleapplevelup.activity.onBoarding.OnBoardingActivity

class MainActivity : AppCompatActivity() {


    //    region LifeCycle Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val helper: SharedPreferenceHelper = SharedPreferenceHelper.getInstance(this)
        if (helper.getIfFirstTime()) {
            UtilFunction.gotoActivity(this, OnBoardingActivity::class.java)
        }
        else{
            if(helper.getUser()==null)
                UtilFunction.gotoActivityWithFinish(this, LoginActivity::class.java)
            else {
                if (helper.getUser()!!.firstLogin) {
                    UtilFunction.gotoActivityWithFinish(this, FirstTimePasswordActivity::class.java)

                } else {
                    UtilFunction.gotoActivityWithFinish(this, HomeActivity::class.java)
                }
            }
        }
    }

    //endregion
}