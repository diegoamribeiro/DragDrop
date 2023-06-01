package com.example.dragdrop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dragdrop.databinding.ItemDragBinding

class DragAdapter : RecyclerView.Adapter<DragAdapter.DragViewHolder>() {

    private var list = emptyList<MyData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragViewHolder {
        return DragViewHolder(ItemDragBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: DragViewHolder, position: Int) {
        holder.bindViews(list[position])
    }

    fun setData(list: List<MyData>) {
        this.list = list
    }

    inner class DragViewHolder(private val binding: ItemDragBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindViews(item: MyData) {
            binding.tvNumber.text = item.number.toString()
            binding.tvName.text = item.name
        }
    }
}