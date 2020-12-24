package com.brainXTech.sampleapplevelup.fragments.dashBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.brainXTech.sampleapplevelup.ModelClasses.GridItems
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.adapters.HomeGridAdapter
import com.brainXTech.sampleapplevelup.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeFragmentBinding: FragmentHomeBinding

    var elements: ArrayList<GridItems> = ArrayList<GridItems>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeFragmentBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return homeFragmentBinding.root
    }

    override fun onStart() {
        super.onStart()
        populateElements()
        setGridAdapter()

    }

    private fun populateElements() {
        elements.clear()
        elements.add(GridItems("Do Today",R.drawable.ic_do_today))
        elements.add(GridItems("Activities and Tips",R.drawable.ic_activities___tips))
        elements.add(GridItems("Track It",R.drawable.ic_track_it))
        elements.add(GridItems("Plan",R.drawable.ic_plan))
        elements.add(GridItems("Training",R.drawable.ic_training))
        elements.add(GridItems("Say & Share",R.drawable.ic_say_and_share))
    }

    private fun setGridAdapter() {
        homeGridView.adapter=HomeGridAdapter(requireActivity(),elements)


    }


}