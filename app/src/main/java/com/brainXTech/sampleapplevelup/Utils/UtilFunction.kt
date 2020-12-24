package com.brainXTech.sampleapplevelup.Utils

import android.app.Activity
import android.content.Intent

object UtilFunction {


    fun gotoActivityWithFinish(currentContext: Activity,activityClass: Class<Any>){
        val value = Intent (currentContext, activityClass::class.java)
        currentContext.startActivity(value)
        currentContext.finish()
    }

    fun gotoActivity(currentContext: Activity,activityClass: Class<Any>){
        val value = Intent (currentContext, activityClass::class.java)
        currentContext.startActivity(value)
    }
}