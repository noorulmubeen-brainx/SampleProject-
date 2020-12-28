package com.brainXTech.sampleapplevelup.fragments.dashBoard

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.afollestad.materialdialogs.MaterialDialog
import com.brainXTech.sampleapplevelup.R
import com.brainXTech.sampleapplevelup.Utils.UtilFunction
import com.brainXTech.sampleapplevelup.activity.login.LoginActivity
import com.brainXTech.sampleapplevelup.databinding.FragmentSettingsBinding
import com.brainXTech.sampleapplevelup.viewModel.SettingsViewModel
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment(), View.OnClickListener {
//region Private Properties
    private lateinit var settingsFragmentBinding: FragmentSettingsBinding
    private lateinit var settingsViewModel: SettingsViewModel
    private lateinit var dialog: MaterialDialog
//endregion

//    region LifeCycleMethods

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        settingsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        settingsFragmentBinding.lifecycleOwner = this
        setObserver()
        return settingsFragmentBinding.root
    }


    override fun onStart() {
        super.onStart()
        addListener()
    }
//endregion
//    PrivateMethods

    private fun setObserver() {
        settingsViewModel = ViewModelProvider(this).get(SettingsViewModel::class.java).apply {
            dialogueToShow.observe(viewLifecycleOwner, showConfirmationDialogCallBack)
            dialogueToShow.observe(viewLifecycleOwner, showConfirmationDialogCallBack)
            loading.observe(viewLifecycleOwner, showLoading)
            gotoLogin.observe(viewLifecycleOwner, gotoLoginScreen)
        }
    }

    private fun showDialog() {
        dialog = MaterialDialog(requireContext()).also {
            it.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            it.setContentView(R.layout.dialogue_logout_confirmation)
            val button = it.findViewById<Button>(R.id.logoutConfirm)
            val cancelButton = it.findViewById<Button>(R.id.cancel_button)
            button.setOnClickListener(this)
            cancelButton.setOnClickListener(this)
        }
        dialog.show()


    }


    private fun addListener() {
        logOutButton.setOnClickListener(this)
    }

    //endregion
//    region Implemented Method
    override fun onClick(v: View?) {
        settingsViewModel.onClick(v)
    }
//    endregion

    //    region Callback Methods
    private val showConfirmationDialogCallBack = Observer<Boolean> {
        if (it) {
            showDialog()
        } else {
            if (dialog.isShowing)
                dialog.dismiss()
        }

    }
    private val gotoLoginScreen = Observer<Boolean> {
        if (it) {
            UtilFunction.gotoActivityWithFinish(requireActivity(), LoginActivity::class.java)
        }
    }

    private val showLoading = Observer<Boolean> {
        if (it) {
            loadingProgress.visibility = View.VISIBLE
            logOutButton.visibility = View.INVISIBLE
        } else {
            loadingProgress.visibility = View.INVISIBLE
            logOutButton.visibility = View.VISIBLE
        }

    }
//end region

}