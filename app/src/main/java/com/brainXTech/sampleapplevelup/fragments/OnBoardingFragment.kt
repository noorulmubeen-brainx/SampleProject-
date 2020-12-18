package com.brainXTech.sampleapplevelup.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.databinding.OnBoardingFragmentBinding

class OnBoardingFragment(private val currentIndex:Int) : Fragment() {
    private lateinit var onBoardingBinding:OnBoardingFragmentBinding
    private lateinit var  textView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        onBoardingBinding=DataBindingUtil.inflate(inflater,R.layout.on_boarding_fragment, container, false)
        return onBoardingBinding.root
    }


    override fun onStart() {
        super.onStart()
        textView=onBoardingBinding.helloWorld.apply {
            this.text="${this.text} ${currentIndex}"
        }


    }

}