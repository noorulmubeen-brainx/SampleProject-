package com.brainXTech.sampleapplevelup.baseClasses

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.brainXTech.sampleapplevelup.Utils.SharedPreferenceHelper

open class BaseViewModel(val app: Application) : AndroidViewModel(app) {
    //region Public Properties
    val loading = MutableLiveData<Boolean>()
    val sharedPreference = SharedPreferenceHelper.getInstance(app)

    // endregion
//    region LifecycleMethods
    init {
        loading.value = false
    }

    //    endregion
//    region Public Methods
    fun showToastMessage(message: String) {
        if (message != "")
            Toast.makeText(app, message, Toast.LENGTH_LONG).show()
    }

    fun setLoading(b: Boolean) {
        loading.postValue(b)
    }
//    endregion
}