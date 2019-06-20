package com.sahabatdeveloper.dottest.module

import android.content.Context
import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sahabatdeveloper.dottest.R
import com.sahabatdeveloper.dottest.model.Model

public class DataImageAdapter(private val context: Context, private val listData: List<Model.Data>) : RecyclerView.Adapter<DataImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_data, parent, false))
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item: Model.Data = listData[position]

        if (item.type.equals("image")){
            holder.linear1.visibility = VISIBLE
            holder.linear2.visibility = GONE
            Glide.with(context).load(item.media[0]).placeholder(R.drawable.placeholder).into(holder.imgData)
            holder.tvTitle1.text = item.title
            holder.tvSubTitle1.text = item.content
        }else{
            holder.linear1.visibility = GONE
            holder.linear2.visibility = VISIBLE
            holder.tvTitle2.text = item.title
            holder.tvSubTitle2.text = item.content
            holder.rvImage.layoutManager = LinearLayoutManager(context,HORIZONTAL,false)
            holder.rvImage.setHasFixedSize(true)
            holder.rvImage.adapter = ImageAdapter(context,item.media)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var rvImage: RecyclerView = itemView.findViewById(R.id.rv_image)
        var imgData: ImageView = itemView.findViewById(R.id.img_gambar1)
        var tvTitle1: TextView = itemView.findViewById(R.id.tv_title1)
        var tvSubTitle1: TextView = itemView.findViewById(R.id.tv_subtitle1)
        var tvTitle2: TextView = itemView.findViewById(R.id.tv_title2)
        var tvSubTitle2: TextView = itemView.findViewById(R.id.tv_subtitle2)
        var linear1: LinearLayout = itemView.findViewById(R.id.linear1)
        var linear2: LinearLayout = itemView.findViewById(R.id.linear2)
    }


}
