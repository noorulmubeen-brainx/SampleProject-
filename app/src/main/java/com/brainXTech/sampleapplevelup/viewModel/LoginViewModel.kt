package com.brainXTech.sampleapplevelup.viewModel

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.brainXTech.sampleapplevelup.ModelClasses.User
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.ApplicationConstants
import com.brainXTech.sampleapplevelup.Utils.SharedPreferenceHelper
import com.brainXTech.sampleapplevelup.Utils.isValidEmail
import com.brainXTech.sampleapplevelup.Utils.isValidPassword
import com.brainXTech.sampleapplevelup.`interface`.IResponse
import com.brainXTech.sampleapplevelup.baseClasses.BaseViewModel
import com.brainXTech.sampleapplevelup.network.UserAPIConnection

class LoginViewModel(app: Application) : BaseViewModel(app) {
//    region Mutable values
    val isShowing = MutableLiveData<Boolean>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    private val apiRequestBody = HashMap<String,Any?>()
    val moveToFirstTimePassword=MutableLiveData<Boolean>()
//    endregion
//    region private Properties
//    endregion

//region lifecycle
    init {
        isShowing.value = true
        email.value = ""
        password.value = ""
    }

//    endregion

//    region implemented method
    fun onClickListener(v: View?) {
        when (v?.id) {
            R.id.showHidePassword -> {
                isShowing.value = !isShowing.value!!
            }
            R.id.signInButton -> {
                setLogin()
            }
        }
    }
// endregion

//    region private method

    private fun setUserToPreference(user:User){
        sharedPreference.setUser(user)
    }


    private fun setLogin() {
        setLoading(true)
        if (!email.value!!.isValidEmail()) {
            showToastMessage(app.getString(R.string.email_not_valid))
            setLoading(false)
            return
        }
        else if (!password.value!!.isValidPassword()) {
            showToastMessage(app.getString(R.string.password_not_correct))
            setLoading(false)
            return
        }
        callApiSignIn()
        return
    }

    private val signInLister = object : IResponse<User, String> {
        override fun onSuccess(result: User) {
            setUserToPreference(result)
            setLoading(false)
            if(result.firstLogin)
                moveToFirstTimePassword.postValue(true)
            else
                moveToFirstTimePassword.postValue(false)
        }

        override fun onFailure(error: String) {
            setLoading(false)
            showToastMessage(error)

        }
    }

    private fun callApiSignIn() {
        apiRequestBody.put("email",email.value)
        apiRequestBody.put("password",password.value)
        apiRequestBody.put("app_platform",ApplicationConstants.APP_TYPE)
        apiRequestBody.put("app_version",ApplicationConstants.APP_VERSION)
        UserAPIConnection.signInUser(apiRequestBody,signInLister)
    }


//end region

}