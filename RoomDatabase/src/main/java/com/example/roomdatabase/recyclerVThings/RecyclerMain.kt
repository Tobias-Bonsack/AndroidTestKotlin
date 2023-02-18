package com.example.roomdatabase.recyclerVThings

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdatabase.R
import com.example.roomdatabase.databinding.ActivityRecyclerMainBinding

class RecyclerMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRecyclerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TestAdapter(ItemDB.itemList)
        binding.testRV.adapter = adapter

        binding.recyclerView.adapter = TestAdapter(ItemDB.itemList2)

        binding.button5.setOnClickListener {
            ItemDB.itemList.add(TestItem("asdf", "qwer"))
            adapter.notifyDataSetChanged()
        }

        binding.button6.setOnClickListener {
            ItemDB.itemList2.add(TestItem("asdf2", "qwer2"))
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }

    }
}