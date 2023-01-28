package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QA_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qa_main)
        supportActionBar?.hide()

    }
}