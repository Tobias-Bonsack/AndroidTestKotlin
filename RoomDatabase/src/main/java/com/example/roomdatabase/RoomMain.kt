package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.roomdatabase.recyclerVThings.RecyclerMain

class RoomMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_main)

        findViewById<Button>(R.id.button2).setOnClickListener {
            startActivity(Intent(this, RecyclerMain::class.java))
        }
    }
}