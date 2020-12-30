package com.brainXTech.sampleapplevelup.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.brainXTech.sampleapplevelup.ModelClasses.User
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.isValidPassword
import com.brainXTech.sampleapplevelup.`interface`.IResponse
import com.brainXTech.sampleapplevelup.baseClasses.BaseViewModel
import com.brainXTech.sampleapplevelup.network.UserAPIConnection

class FirstTimePasswordViewModel(app: Application) : BaseViewModel(app) {
    //region PUBLIC_PROPERTIES
    val newPassword = MutableLiveData<String>()
    val againPassword = MutableLiveData<String>()
    val moveToHome = MutableLiveData<Boolean>()
    lateinit var user: User

    //endregion
//    region Private Method
    private fun setUpdatePassword() {
        setLoading(true)
        if (!newPassword.value!!.isValidPassword() || !againPassword.value!!.isValidPassword()) {
            showToastMessage(app.getString(R.string.password_not_correct))
            setLoading(false)
        } else if (newPassword.value != againPassword.value) {
            showToastMessage(app.getString(R.string.password_do_not_match))
            setLoading(false)
        } else {
            setDataToAPI()
        }

    }

    private fun setDataToAPI() {
        user = sharedPreference.getUser()!!
        UserAPIConnection.changeUserPassword(
            user.accessToken!!, user.uid,
            user.client!!, changePasswordListener
        )

    }

    //endregion
//    region ImplementedMethod
    fun onClickListener(v: View?) {
        when (v?.id) {
            R.id.updatePassword -> {
                setUpdatePassword()

            }
        }
    }

//    endregion


    //    region Callbacks

    private val changePasswordListener = object : IResponse<Map<String, Any?>, String> {
        override fun onFailure(error: String) {
            setLoading(false)
            showToastMessage(error)

        }

        override fun onSuccess(result: Map<String, Any?>) {
            user.firstLogin = false
            sharedPreference.setUser(user)
            setLoading(false)
            moveToHome.postValue(true)
        }
    }

//endregion

}