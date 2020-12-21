package com.brainXTech.sampleapplevelup.activity.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.databinding.ActivityLoginBinding
import com.brainXTech.sampleapplevelup.databinding.ActivityOnBoardingBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    //    region properties
    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var passwordShowHideIcon: ImageView
    private lateinit var signInButton: Button
    private var isShowing:Boolean=false


//    endregion

//region Implemented Methods
    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
        when(v?.id){
            R.id.showHidePassword->{
                showPassword(isShowing)

            }
        }
    }

    private fun showPassword(b: Boolean) {
        if(b){
            passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance())
            showHidePassword.setImageResource(R.drawable.ic_eye)
        }
        else{
            passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
            showHidePassword.setImageResource(R.drawable.ic_closed_eye)
        }
        isShowing=!isShowing
        passwordEditText.setSelection(passwordEditText.text.length);
    }

//    endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setListeners()
    }

    private fun setListeners() {
//        TODO("Not yet implemented")
        passwordShowHideIcon.setOnClickListener(this)
    }

    private fun setBinding() {
//        TODO("Not yet implemented")
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        signInButton=loginBinding.button
        emailEditText=loginBinding.editTextTextEmailAddress
        passwordEditText=loginBinding.editTextTextPassword
        passwordShowHideIcon=loginBinding.showHidePassword
    }
}