package com.brainXTech.sampleapplevelup.activity.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.brainXTech.sampleapplevelup.viewModel.LoginViewModel
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.UtilFunction
import com.brainXTech.sampleapplevelup.activity.dashboard.HomeActivity
import com.brainXTech.sampleapplevelup.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    //    region Private properties
    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel


    //    endregion
//    region LifeCycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setListeners()
    }

    //    endregion
// region Private method
    private fun setListeners() {
        showHidePassword.setOnClickListener(this)
        signInButton.setOnClickListener(this)
    }

    private fun setBinding() {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginBinding.lifecycleOwner = this
        loginBinding.viewModel = loginViewModel
        loginViewModel.also {
            it.isShowing.observe(this, showHidePasswordCallBack)
            it.moveToFirstTimePassword.observe(this, moveToNextScreen)
            it.loading.observe(this, showProgress)
        }
    }

    //    endregion
//region Implemented Methods
    override fun onClick(v: View?) {
        loginViewModel.onClickListener(v)
    }


//    endregion
//    region CALLBACKS

    private val showProgress = Observer<Boolean> {
        if (it) {
            signInButton.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
        } else {
            signInButton.visibility = View.VISIBLE
            progressBar.visibility = View.INVISIBLE
        }
    }

    private val showHidePasswordCallBack = Observer<Boolean> {
        showPassword(it)
    }

    private fun showPassword(showPassword: Boolean) {
        if (showPassword) {
            editTextTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        } else {
            editTextTextPassword.transformationMethod =
                HideReturnsTransformationMethod.getInstance()
        }
        editTextTextPassword.setSelection(editTextTextPassword.text.length)
    }

    private val moveToNextScreen = Observer<Boolean> {
        if (it) {
            UtilFunction.gotoActivityWithFinish(this, FirstTimePasswordActivity::class.java)
        } else
            UtilFunction.gotoActivityWithFinish(this, HomeActivity::class.java)


    }
// endregion
}
