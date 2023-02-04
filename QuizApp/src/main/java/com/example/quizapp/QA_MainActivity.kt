package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class QA_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qa_main)
        supportActionBar?.hide()

        val nameTV = findViewById<TextView>(R.id.nameTV)
        val startBtn = findViewById<Button>(R.id.startBtn)
        startBtn.setOnClickListener {
            if (nameTV.text.isBlank()) {
                Toast.makeText(this, "Please enter Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, QaQuestionsActivity::class.java)
            intent.apply {
                putExtra("progressValue", 0)
            }
            startActivity(intent)
            finish() // can not go back
        }
    }

    override fun onResume() {
        super.onResume()
        window.decorView.windowInsetsController?.hide(WindowInsets.Type.statusBars())
    }

}