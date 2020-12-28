package com.brainXTech.sampleapplevelup.Utils

import android.app.Activity
import android.content.Intent

object UtilFunction {


    fun gotoActivityWithFinish(currentContext: Activity,cls:Class<*>){
        val value = Intent (currentContext, cls)
        currentContext.startActivity(value)
        currentContext.finish()
    }

    fun gotoActivity(currentContext: Activity,cls:Class<*>){
        val value = Intent (currentContext, cls)
        currentContext.startActivity(value)
    }
}