package com.brainXTech.sampleapplevelup.fragments.dashBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.brainXTech.sampleapplevelup.ModelClasses.GridItems
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.SharedPreferenceHelper
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
        setName()
        populateElements()
        setGridAdapter()

    }

    private fun setName() {
        val user = SharedPreferenceHelper.getInstance(requireContext()).getUser()
        nameText.text = user?.name
    }

    private fun populateElements() {
        elements.clear()
        elements.add(GridItems(getString(R.string.do_today), R.drawable.ic_do_today))
        elements.add(
            GridItems(
                getString(R.string.activities_and_tips),
                R.drawable.ic_activities___tips
            )
        )
        elements.add(GridItems(getString(R.string.track_it), R.drawable.ic_track_it))
        elements.add(GridItems(getString(R.string.plan), R.drawable.ic_plan))
        elements.add(GridItems(getString(R.string.training), R.drawable.ic_training))
        elements.add(GridItems(getString(R.string.say_and_share), R.drawable.ic_say_and_share))
    }

    private fun setGridAdapter() {
        homeGridView.adapter=HomeGridAdapter(requireActivity(),elements)


    }


}