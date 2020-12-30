package com.brainXTech.sampleapplevelup.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.brainXTech.sampleapplevelup.ModelClasses.GridItems
import com.brainXTech.sampleapplevelup.R

class HomeGridAdapter(private val context: Context,private val elements:List<GridItems>):BaseAdapter() {

// region Implemented Methods

    override fun getCount(): Int {
        return elements.size
    }

    override fun getItem(position: Int): Any {
    return elements.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = View.inflate(context, R.layout.home_grid_element_layout,null)
        val image=view.findViewById<ImageView>(R.id.current_grid_image)
        val text=view.findViewById<TextView>(R.id.current_grid_text)
        text.text=elements.get(position).textData
        image.setImageResource(elements.get(position).imageId)
        return view
    }
//    endregion
}