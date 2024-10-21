package com.example.vk_homework1_stepanova_a_andr_12

import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RectanglesFragment : Fragment(R.layout.fragment_rectangles), OnCLickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rectanglesRecyclerView = view.findViewById<RecyclerView>(R.id.rv_rectangles)
        val spanCount: Int =
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 3
            else 4
        rectanglesRecyclerView.layoutManager = GridLayoutManager(activity, spanCount)
        val rectanglesAdapter = RectanglesAdapter(this)
        rectanglesRecyclerView.adapter = rectanglesAdapter

        view.findViewById<FloatingActionButton>(R.id.fab_add_new_rectangle).setOnClickListener {
            val num = rectanglesAdapter.addNewRectangle()
            rectanglesRecyclerView.scrollToPosition(num)
        }
    }

    override fun changeBackgroundColor(number: Int): Drawable {
        return if (number % 2 == 0) {
            ContextCompat.getDrawable(
                requireContext(),
                R.color.red
            )!!
        } else {
            ContextCompat.getDrawable(requireContext(), R.color.blue)!!
        }
    }
}