package com.example.vk_homework1_stepanova_a_andr_12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RectanglesAdapter(private val listener: OnCLickListener) :
    RecyclerView.Adapter<RectanglesAdapter.RectangleViewHolder>() {

    private val listOfNumbers = mutableListOf<Int>()

    fun addNewRectangle() : Int {
        listOfNumbers.add(listOfNumbers.size)
        val num = listOfNumbers.size - 1
        notifyItemInserted(num)
        return num
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RectangleViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.rectangle_item_view, parent, false)
        return RectangleViewHolder(itemView)
    }

    override fun getItemCount(): Int = listOfNumbers.size

    override fun onBindViewHolder(holder: RectangleViewHolder, position: Int) {
        val currentNumber = listOfNumbers[position]
        holder.number.text = currentNumber.toString()
        holder.background.background = listener.changeBackgroundColor(currentNumber)
    }

    inner class RectangleViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val number: TextView = itemView.findViewById(R.id.tv_number)
        val background: ImageView = itemView.findViewById(R.id.iv_background)
    }
}