package com.example.vk_homework1_stepanova_a_andr_12

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_homework1_stepanova_a_andr_12.adapter.RectanglesAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RectanglesFragment : Fragment(R.layout.fragment_rectangles), OnCLickListener {

    private val bundleKey = "BUNDLE_KEY"
    private val list = arrayListOf(0, 1, 2, 3, 4)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rectanglesRecyclerView = view.findViewById<RecyclerView>(R.id.rv_rectangles)
        val rectanglesAdapter = RectanglesAdapter(this)
        rectanglesRecyclerView.adapter = rectanglesAdapter

        if (savedInstanceState != null) {
            val bundle = savedInstanceState.getIntegerArrayList(bundleKey)
            list.apply {
                clear()
                addAll(bundle ?: emptyList())
            }
        }

        rectanglesAdapter.setList(list)

        view.findViewById<FloatingActionButton>(R.id.fab_add_new_rectangle).setOnClickListener {
            val num = list.lastIndex + 1
            list.add(num)
            rectanglesAdapter.addNewRectangle(num)
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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntegerArrayList(bundleKey, list)
        super.onSaveInstanceState(outState)
    }
}