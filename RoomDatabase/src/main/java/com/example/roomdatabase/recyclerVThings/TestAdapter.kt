package com.example.roomdatabase.recyclerVThings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.databinding.RecyclerviewItemBinding

class TestAdapter(val itemList: List<TestItem>) : RecyclerView.Adapter<TestAdapter.MainViewHolder>() {

    inner class MainViewHolder(val itemBinding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(item: TestItem) {
            itemBinding.textView3.text = item.firtOne
            itemBinding.textView4.text = item.secondOne
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = itemList[position]
        holder.bindItem(item)
    }
}