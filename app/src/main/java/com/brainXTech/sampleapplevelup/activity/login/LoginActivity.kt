package com.brainXTech.sampleapplevelup.activity.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.brainXTech.sampleapplevelup.viewModel.LoginViewModel
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    //    region properties
    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel


//    endregion

    //region Implemented Methods
    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
        loginViewModel.onClickListener(v)
    }


//    endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setListeners()
    }


    private fun setListeners() {
        showHidePassword.setOnClickListener(this)
        signInButton.setOnClickListener(this)
    }

    private fun setBinding() {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginBinding.lifecycleOwner = this
        loginBinding.viewModel = loginViewModel
        loginViewModel.isShowing.observe(this, showHidePasswordCallBack)
        loginViewModel.showToastMessage.observe(this, showToastMessage)
    }

    private val showToastMessage = Observer<String> {
        if (it != "")
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()

    }

    private fun showToast() {

    }

    private val showHidePasswordCallBack = Observer<Boolean> {
        showPassword(it)
    }

    private fun showPassword(b: Boolean) {
        if (b) {
            editTextTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        } else {
            editTextTextPassword.transformationMethod =
                HideReturnsTransformationMethod.getInstance()
        }
        editTextTextPassword.setSelection(editTextTextPassword.text.length)
    }

}