package com.brainXTech.sampleapplevelup.viewModel

import android.app.Application
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.brainXTech.sampleapplevelup.ModelClasses.User
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.isValidEmail
import com.brainXTech.sampleapplevelup.Utils.isValidPassword
import com.brainXTech.sampleapplevelup.`interface`.IResponse
import com.brainXTech.sampleapplevelup.network.BaseAPIManager
import com.brainXTech.sampleapplevelup.network.UserAPIConnection

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    val isShowing = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val showToastMessage = MutableLiveData<String>()
    val data = HashMap<String,Any?>()
    val moveToFirstTimePassword=MutableLiveData<Boolean>()

    init {
        isShowing.value = true
        email.value = ""
        password.value = ""
        loading.value=false
    }


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

    private fun setLogin() {
//        TODO("Not yet implemented")
        if (!email.value!!.isValidEmail()) {
            showToastMessage.postValue("Please enter a valid Email")
            return
        }
        else if (!password.value!!.isValidPassword()) {
            showToastMessage.postValue("Please enter a valid Password")
            return
        }
        callApiSignIn()
        return
    }

    private val signInLister = object : IResponse<User, String> {
        override fun onSuccess(result: User) {
//            progressDialog.dismiss()
            print(result)
//            val intent = Intent(applicationContext, ProfileActivity::class.java)
//            startActivity(intent)
        }

        override fun onFailure(error: String) {
//            progressDialog.dismiss()
            showToastMessage.postValue(error)

        }
    }

    private fun callApiSignIn() {
        data.put("email",email.value)
        data.put("password",password.value)
        data.put("app_platform","android")
        data.put("app_version",1)
        UserAPIConnection.signInUser(data,signInLister)
    }


}