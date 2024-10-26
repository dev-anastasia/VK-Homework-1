package com.example.vk_homework1_stepanova_a_andr_12.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_homework1_stepanova_a_andr_12.OnCLickListener
import com.example.vk_homework1_stepanova_a_andr_12.R

class RectanglesAdapter(private val listener: OnCLickListener) :
    RecyclerView.Adapter<RectangleViewHolder>() {

    private val list = mutableListOf<Int>()

    fun setList(list: List<Int>) {
        this.list.apply {
            clear()
            addAll(list)
        }
    }

    fun addNewRectangle(num: Int) {
        list.add(num)
        notifyItemInserted(num)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RectangleViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.rectangle_item_view, parent, false)
        return RectangleViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RectangleViewHolder, position: Int) {
        val currentNumber = list[position]
        holder.number.text = currentNumber.toString()
        holder.background.background = listener.changeBackgroundColor(currentNumber)
    }
}