package com.brainXTech.sampleapplevelup.customViews

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.brainXTech.sampleapplevelup.R

class CustomDialogue(private val layoutToSet:Int, context: Context):Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutToSet)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }


}