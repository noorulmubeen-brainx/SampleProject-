package com.brainXTech.sampleapplevelup.Utils

import android.content.Context
import android.content.SharedPreferences
import com.brainXTech.sampleapplevelup.ModelClasses.User
import com.google.gson.Gson

class SharedPreferenceHelper {


    //    region Properties
    private val APP_NAME = "SampleLevelUp"
    private val IS_FIRST_TIME = "IsFirstTimeApp"
    private lateinit var sharedPref: SharedPreferences
    private val USER ="currentUser"
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
    fun getUser(): User? {
        val gson = Gson()
        val user: User?
        if(sharedPref.getString(USER,"")=="")
            return null
        user = gson.fromJson(sharedPref.getString(USER, ""), User::class.java)
        return user
    }
//    endregion


    //    region setValues
    fun setIfFirstTime(value: Boolean) {
        sharedPref.edit().apply() {
            this.putBoolean(IS_FIRST_TIME, value)?.apply()
        }
    }


    fun setUser(user: User?) {
        val gson = Gson()
        val json = gson.toJson(user)

        val editor = sharedPref.edit()
        editor?.putString(USER, json)
        editor?.apply()
    }


//    endregion
}