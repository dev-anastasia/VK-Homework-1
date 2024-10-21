package com.example.vk_homework1_stepanova_a_andr_12

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RectanglesFragment : Fragment(R.layout.fragment_rectangles) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rectanglesRecyclerView = view.findViewById<RecyclerView>(R.id.rv_rectangles)
        rectanglesRecyclerView.layoutManager = GridLayoutManager(activity, 3)
        val rectanglesAdapter = RectanglesAdapter()
        rectanglesRecyclerView.adapter = rectanglesAdapter
    }
}