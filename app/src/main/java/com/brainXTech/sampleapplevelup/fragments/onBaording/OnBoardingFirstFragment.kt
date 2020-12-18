package com.brainXTech.sampleapplevelup.fragments.onBaording

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.databinding.OnBoardingFragmentBinding

class OnBoardingFirstFragment(private val currentIndex:Int) : Fragment() {
    private lateinit var onBoardingBinding: OnBoardingFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        onBoardingBinding=DataBindingUtil.inflate(inflater,R.layout.on_boarding_fragment, container, false)
        return onBoardingBinding.root
    }


    override fun onStart() {
        super.onStart()
        resetDotsSource()
        setSelectedDot()


    }

    private fun setSelectedDot() {
        when(currentIndex){
            0-> onBoardingBinding.firstDot.setImageResource(R.drawable.ic_selected_bottom_point)
            1->onBoardingBinding.secondDot.setImageResource(R.drawable.ic_selected_bottom_point)
            2->onBoardingBinding.thirdDot.setImageResource(R.drawable.ic_selected_bottom_point)
        }
    }

    private fun resetDotsSource() {
        onBoardingBinding.firstDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
        onBoardingBinding.secondDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
        onBoardingBinding.thirdDot.setImageResource(R.drawable.ic_not_selected_bottom_point)
    }

}