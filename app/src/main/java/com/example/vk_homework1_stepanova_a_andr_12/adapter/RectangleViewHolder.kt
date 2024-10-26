package com.example.vk_homework1_stepanova_a_andr_12.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_homework1_stepanova_a_andr_12.R

class RectangleViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    val number: TextView = itemView.findViewById(R.id.tv_number)
    val background: ImageView = itemView.findViewById(R.id.iv_background)
}