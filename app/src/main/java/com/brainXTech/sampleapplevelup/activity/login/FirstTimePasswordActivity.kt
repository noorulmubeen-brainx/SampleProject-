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
import com.brainXTech.sampleapplevelup.activity.MainActivity
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
        firstTimeViewModel.loading.observe(this,setProgresbar)


    }

    private val setProgresbar= Observer<Boolean>{
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
        Toast.makeText(this,"You should be at home Screen",Toast.LENGTH_LONG).show()
        val value = Intent (this, MainActivity::class.java)
        startActivity(value)
    }


}