package com.example.retro

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class listAdapter(context: Context, dataArrayList: List<MarsPhoto>?)
    : ArrayAdapter<MarsPhoto?>(context, R.layout.list_item, dataArrayList!!) {
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val listData = getItem(position)
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }
        val listImage = view!!.findViewById<ImageView>(R.id.imageView)
        val listName = view.findViewById<TextView>(R.id.textView)
        val uri = Uri.parse(listData!!.img_src)
        Glide.with(context)
            .load(uri)
            .into(listImage)
        listName.text = listData.id
        return view
    }


}