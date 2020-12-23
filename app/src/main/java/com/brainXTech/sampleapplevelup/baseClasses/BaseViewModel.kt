package com.brainXTech.sampleapplevelup.baseClasses

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.brainXTech.sampleapplevelup.Utils.SharedPreferenceHelper

open class BaseViewModel(val app: Application) : AndroidViewModel(app) {

    val loading = MutableLiveData<Boolean>()
    val sharedPreference = SharedPreferenceHelper()

    init {
        loading.value = false
        sharedPreference.also { it.setSharedPreference(app) }
    }

    fun showToastMessage(message: String) {
        if (message != "")
            Toast.makeText(app, message, Toast.LENGTH_LONG).show()
    }

    fun setLoading(b: Boolean) {
        loading.postValue(b)
    }


}