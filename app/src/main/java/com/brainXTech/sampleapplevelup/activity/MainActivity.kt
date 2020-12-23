package com.brainXTech.sampleapplevelup.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.SharedPreferenceHelper
import com.brainXTech.sampleapplevelup.activity.login.FirstTimePasswordActivity
import com.brainXTech.sampleapplevelup.activity.login.LoginActivity
import com.brainXTech.sampleapplevelup.activity.onBoarding.OnBoardingActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        TODO("Check if we need to show the on boarding screens?")
//        TODO("get shared preference and check if first time or not")



    }

    override fun onStart() {
        super.onStart()
        val helper:SharedPreferenceHelper=SharedPreferenceHelper().also {
            it.setSharedPreference(this)
        }
        if (helper.getIfFirstTime()){
            moveToOnBoarding()
//            TODO: Move to OnBoarding screens
        }
        else{
            if(helper.getUser()==null)
                moveToLogin()
            else{
                Toast.makeText(this,"User Is logged in",Toast.LENGTH_LONG).show()
                if (helper.getUser()!!.firstLogin){
                    Toast.makeText(this,"User need to set password",Toast.LENGTH_LONG).show()
                    moveToSetPasswordFirstTime()
                }
                else{
                    Toast.makeText(this,"User need to go to home screen",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun moveToSetPasswordFirstTime() {
        val value = Intent (this, FirstTimePasswordActivity::class.java)
        startActivity(value)
    }

    private fun moveToLogin() {
        val value = Intent (this, LoginActivity::class.java)
        startActivity(value)
    }

    private fun moveToOnBoarding() {
        val value = Intent (this, OnBoardingActivity::class.java)
        startActivity(value)
    }
}