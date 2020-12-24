package com.brainXTech.sampleapplevelup.viewModel

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.brainXTech.sampleapplevelup.ModelClasses.User
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.*
import com.brainXTech.sampleapplevelup.`interface`.IResponse
import com.brainXTech.sampleapplevelup.baseClasses.BaseViewModel
import com.brainXTech.sampleapplevelup.network.UserAPIConnection

class LoginViewModel(app: Application) : BaseViewModel(app) {
//    region Mutable values
    val isShowing = MutableLiveData<Boolean>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val moveToFirstTimePassword = MutableLiveData<Boolean>()

    //    endregion
//    region private Properties
    private val apiRequestBody = HashMap<String, Any?>()
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


    private fun callApiSignIn() {
        apiRequestBody.clear()
        apiRequestBody.put(ApiConstants.SIGNIN_BODY_EMAIL, email.value)
        apiRequestBody.put(ApiConstants.SIGNIN_BODY_PASSWORD, password.value)
        apiRequestBody.put(ApiConstants.SIGNIN_BODY_APP_PLATFORM, ApplicationConstants.APP_TYPE)
        apiRequestBody.put(ApiConstants.SIGNIN_BODY_APP_VERSION, ApplicationConstants.APP_VERSION)
        UserAPIConnection.signInUser(apiRequestBody, signInLister)
    }


//end region

    //    region CallbackMethod
    private val signInLister = object : IResponse<User, String> {
        override fun onSuccess(result: User) {
            setUserToPreference(result)
            setLoading(false)
            if (result.firstLogin)
                moveToFirstTimePassword.postValue(true)
            else
                moveToFirstTimePassword.postValue(false)
        }

        override fun onFailure(error: String) {
            setLoading(false)
            showToastMessage(error)

        }
    }
//    endregion

}