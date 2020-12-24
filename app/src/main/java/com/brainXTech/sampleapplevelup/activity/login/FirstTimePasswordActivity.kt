package com.brainXTech.sampleapplevelup.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.ApplicationConstants
import com.brainXTech.sampleapplevelup.activity.dashboard.HomeActivity
import com.brainXTech.sampleapplevelup.databinding.ActivityFirstTimePasswordBinding
import com.brainXTech.sampleapplevelup.viewModel.FirstTimePasswordViewModel
import kotlinx.android.synthetic.main.activity_first_time_password.*

class FirstTimePasswordActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var firstTimeBinding:ActivityFirstTimePasswordBinding
    private lateinit var firstTimeViewModel:FirstTimePasswordViewModel


    override fun onClick(v: View?) {
        firstTimeViewModel.onClickListener(v)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        attachListeners()
    }

    private fun attachListeners() {
        updatePassword.setOnClickListener(this)
    }

    private fun setBinding() {
        firstTimeViewModel=ViewModelProvider(this).get(FirstTimePasswordViewModel::class.java)
        firstTimeBinding=DataBindingUtil.setContentView(this,R.layout.activity_first_time_password)
        firstTimeBinding.lifecycleOwner=this
        firstTimeBinding.viewModel=firstTimeViewModel
        firstTimeViewModel.moveToHome.observe(this,moveToHome)
        firstTimeViewModel.loading.observe(this,setProgressbar)


    }

    private val setProgressbar= Observer<Boolean>{
        if(it){
            changePasswordProgress.visibility=View.VISIBLE
            updatePassword.visibility=View.INVISIBLE
        }
        else{
            updatePassword.visibility=View.VISIBLE
            changePasswordProgress.visibility=View.INVISIBLE
        }
    }

    private val moveToHome= Observer<Boolean>{
        if(it){
            moveTOHomeScreen()
        }
    }
    private fun moveTOHomeScreen() {
        val value = Intent (this, HomeActivity::class.java)
        value.putExtra(ApplicationConstants.SHOW_CHANGE_PASSWORD_DIALOGUE,true)
        startActivity(value)
        finishAffinity()
    }


}