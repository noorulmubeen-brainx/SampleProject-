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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val helper:SharedPreferenceHelper=SharedPreferenceHelper.getInstance(this).also {
        }
        if (helper.getIfFirstTime()){
            moveToOnBoarding()
        }
        else{
            if(helper.getUser()==null)
                moveToLogin()
            else{
                if (helper.getUser()!!.firstLogin){
                    moveToSetPasswordFirstTime()
                }
                else{
                    moveToHomeScreen()
                }
            }
        }
    }


    private fun moveToHomeScreen() {
        UtilFunction.gotoActivityWithFinish(this,HomeActivity::class.java)
    }


    private fun moveToSetPasswordFirstTime() {
        UtilFunction.gotoActivityWithFinish(this,FirstTimePasswordActivity::class.java)
    }

    private fun moveToLogin() {
        UtilFunction.gotoActivityWithFinish(this,LoginActivity::class.java)
    }

    private fun moveToOnBoarding() {
        UtilFunction.gotoActivity(this,OnBoardingActivity::class.java)
    }
}