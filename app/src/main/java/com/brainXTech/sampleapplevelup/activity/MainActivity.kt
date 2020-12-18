package com.brainXTech.sampleapplevelup.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.SharedPreferenceHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        TODO("Check if we need to show the on boarding screens?")
//        TODO("get shared preference and check if first time or not")
        val helper:SharedPreferenceHelper=SharedPreferenceHelper().also {
            it.setSharedPreference(this)
        }
        if (helper.getIfFirstTime()){
            moveToOnBoarding()
//            TODO: Move to OnBoarding screens
        }
        else{
//            TODO: Check the authentication status of current user
//            TODO: if yes move to main screen else go to signIn screen

        }


    }

    private fun moveToOnBoarding() {
        val value = Intent (this,OnBoardingActivity::class.java)
        startActivity(value)
    }
}