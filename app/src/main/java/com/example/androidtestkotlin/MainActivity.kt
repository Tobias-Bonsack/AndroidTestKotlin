package com.example.androidtestkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ageinminutes.AgeInMinuteMain
import com.example.calculator.CalculatorMainActivity

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
    }
}