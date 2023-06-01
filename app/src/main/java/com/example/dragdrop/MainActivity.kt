package com.example.dragdrop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.dragdrop.databinding.ActivityMainBinding
import java.util.Collections

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: DragAdapter

    private var myList = emptyList<MyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myList = listOf(
            MyData(1, "Diego Ribeiro"),
            MyData(2, "Cadu"),
            MyData(3, "Neto"),
            MyData(4, "Leide"),
            MyData(5, "Dudinha"),
            MyData(6, "Victória"),
            MyData(7, "Lindinha")
        )
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        adapter = DragAdapter()
        binding.rvDrag.layoutManager = LinearLayoutManager(this)
        adapter.setData(
            myList
        )
        binding.rvDrag.adapter = adapter

        val simpleDragObject = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP.or(ItemTouchHelper.DOWN), 0) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val startPosition = viewHolder.adapterPosition
                val endPosition = target.adapterPosition

                Collections.swap(myList, startPosition, endPosition)
                binding.rvDrag.adapter?.notifyItemMoved(startPosition, endPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            }
        }

        val itemTouchHelper = ItemTouchHelper(simpleDragObject)
        itemTouchHelper.attachToRecyclerView(binding.rvDrag)
    }
}