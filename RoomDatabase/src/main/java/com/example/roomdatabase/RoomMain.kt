package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.roomdatabase.databinding.ActivityRoomMainBinding
import com.example.roomdatabase.recyclerVThings.RecyclerMain
import com.example.roomdatabase.roomDBThings.SavedApp
import com.example.roomdatabase.roomDBThings.SavedDB
import com.example.roomdatabase.roomDBThings.SavedDao
import com.example.roomdatabase.roomDBThings.SavedEntity
import kotlinx.coroutines.launch

class RoomMain : AppCompatActivity() {

    lateinit var binding: ActivityRoomMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            startActivity(Intent(this, RecyclerMain::class.java))
        }
        val savedDao = (application as SavedApp).db.savedDao()
        binding.addButton.setOnClickListener {
            addSaved(savedDao)
        }
    }

    fun addSaved(savedDao: SavedDao) {
        val first = binding.firstOne.text.toString()
        val second = binding.secondOne.text.toString()

        if (first.isBlank() || second.isBlank()) {
            return
        }

        lifecycleScope.launch {
            savedDao.insert(SavedEntity(firstValue = first, secondValue = second))
            Toast.makeText(applicationContext, "Entrie created!", Toast.LENGTH_SHORT).show()
        }
    }
}