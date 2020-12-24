package com.brainXTech.sampleapplevelup.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.brainXTech.sampleapplevelup.ModelClasses.User
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.SharedPreferenceHelper
import com.brainXTech.sampleapplevelup.`interface`.IResponse
import com.brainXTech.sampleapplevelup.baseClasses.BaseViewModel
import com.brainXTech.sampleapplevelup.network.UserAPIConnection
import kotlinx.android.synthetic.main.fragment_settings.view.*

class SettingsViewModel(app: Application) : BaseViewModel(app) {
    var dialogueToShow = MutableLiveData<Boolean>()
    var gotoLogin = MutableLiveData<Boolean>()
    private var user: User? = null


    fun onClick(v: View?) {
        when (v?.id) {
            R.id.logOutButton -> {
                dialogueToShow.postValue(true)
            }
            R.id.cancel_button -> {
                dialogueToShow.postValue(false)
            }
            R.id.logoutConfirm -> {
                sendCallToAPI()
                dialogueToShow.postValue(false)
            }
        }
    }


    private val signOutListener = object : IResponse<Map<String, Any?>, String> {
        override fun onFailure(error: String) {
            setLoading(false)
            showToastMessage(error)

        }

        override fun onSuccess(result: Map<String, Any?>) {
            user = null
            sharedPreference.setUser(user)
            setLoading(false)
            gotoLogin.postValue(true)
        }
    }

    private fun sendCallToAPI() {
        loading.postValue(true)
        user = SharedPreferenceHelper.getInstance(app).getUser()!!.apply {
            UserAPIConnection.signOutUser(accessToken!!, uid, client!!, signOutListener)
        }

    }
}