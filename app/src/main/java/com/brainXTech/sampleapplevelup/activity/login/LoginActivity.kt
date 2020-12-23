package com.brainXTech.sampleapplevelup.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.brainXTech.sampleapplevelup.ModelClasses.User
import com.brainXTech.sampleapplevelup.viewModel.LoginViewModel
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.SharedPreferenceHelper
import com.brainXTech.sampleapplevelup.activity.MainActivity
import com.brainXTech.sampleapplevelup.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    //    region properties
    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    private val sharedPreference= SharedPreferenceHelper()


//    endregion

    //region Implemented Methods
    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
        loginViewModel.onClickListener(v)
    }


//    endregion

//    region LifeCycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setListeners()
        setSharedPreference()
    }
//    endRegion
// region Private method
    private fun setSharedPreference() {
        sharedPreference.also {
            it.setSharedPreference(this)
        }
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
//        loginViewModel.showToastMessage.observe(this, showToastMessage)
        loginViewModel.moveToFirstTimePassword.observe(this,moveToNextScreen)
        loginViewModel.loading.observe(this,showProgress)
        loginViewModel.user.observe(this,setUserToPreference)
    }

//    endregion

//    region viewModelObservers
    private val setUserToPreference=Observer<User>{
        sharedPreference.setUser(it)
    }



    private val showProgress=Observer<Boolean>{
        if(it){
            signInButton.visibility=View.INVISIBLE
            progressBar.visibility=View.VISIBLE
        }
        else{
            signInButton.visibility=View.VISIBLE
            progressBar.visibility=View.INVISIBLE
        }
    }


    private val showToastMessage = Observer<String> {
        if (it != "")
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()

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
    private val moveToNextScreen=Observer<Boolean> {
        if(it){
            val value = Intent (this, FirstTimePasswordActivity::class.java)
            startActivity(value)
        }
        else{
            val value = Intent (this, MainActivity::class.java)
            startActivity(value)
        }

    }
// endregion
}
