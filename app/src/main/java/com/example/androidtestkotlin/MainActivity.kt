package com.example.androidtestkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.ageinminutes.AgeInMinuteMain

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.ageBtn).setOnClickListener(View.OnClickListener {
            startActivity(Intent(applicationContext, AgeInMinuteMain::class.java))
        })
    }
}