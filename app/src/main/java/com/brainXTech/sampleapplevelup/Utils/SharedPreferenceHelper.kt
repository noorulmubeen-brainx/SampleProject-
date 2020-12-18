package com.brainXTech.sampleapplevelup.Utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceHelper {


    //    region Properties
    private val APP_NAME = "SampleLevelUp"
    private val IS_FIRST_TIME = "IsFirstTimeApp"
    private lateinit var sharedPref: SharedPreferences
//    endregion

    //    region Initialize
    fun setSharedPreference(context: Context) {
        sharedPref = context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)
    }
// endregion

    //    region getValues
    fun getIfFirstTime(): Boolean {
        return sharedPref.getBoolean(IS_FIRST_TIME, true)
    }
//    endregion


    //    region setValues
    fun setIfFirstTime(value: Boolean) {
        sharedPref.edit().apply() {
            this.putBoolean(IS_FIRST_TIME, value)?.apply()
        }
    }
//    endregion
}