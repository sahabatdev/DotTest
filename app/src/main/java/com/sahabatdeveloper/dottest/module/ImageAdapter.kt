package com.sahabatdeveloper.dottest.module

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sahabatdeveloper.dottest.R

public class ImageAdapter(var context: Context, var listMedia: List<String>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image,parent,false))
    }

    override fun getItemCount(): Int = listMedia.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(listMedia[position]).placeholder(R.drawable.placeholder).into(holder.imgData)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgData: ImageView = itemView.findViewById(R.id.img_gambar2)
    }

}
