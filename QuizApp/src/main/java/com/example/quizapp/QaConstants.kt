package com.example.quizapp

object QaConstants {

    private val questionString = "Welches Land is das?"

    val questions = listOf(
        QaQuestion(0, questionString, R.drawable.aland, listOf("Aland", "second", "third", "fourth")),
        QaQuestion(1, questionString, R.drawable.ant, listOf("Antarktis", "second", "third", "fourth")),
        QaQuestion(2, questionString, R.drawable.aruba, listOf("Aruba", "second", "third", "fourth")))

}