package com.example.quizapp

data class QaQuestion(
    val id: Int,
    val question: String,
    val image: Int,
    val answer: List<String>
)
