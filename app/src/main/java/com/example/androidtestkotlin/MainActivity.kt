package com.example.androidtestkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ageinminutes.AgeInMinuteMain
import com.example.calculator.CalculatorMainActivity
import com.example.quizapp.QA_MainActivity
import com.example.roomdatabase.RoomMain

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.ageBtn).setOnClickListener {
            startActivity(Intent(applicationContext, AgeInMinuteMain::class.java))
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            startActivity(Intent(this, CalculatorMainActivity::class.java))
        }

        findViewById<Button>(R.id.quizBtn).setOnClickListener {
            startActivity(Intent(this, QA_MainActivity::class.java))
        }

        findViewById<Button>(R.id.button10).setOnClickListener {
            startActivity(Intent(this, RoomMain::class.java))
        }
    }
}