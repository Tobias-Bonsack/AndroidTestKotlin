package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.random.Random
import kotlin.random.nextInt

class QaQuestionsActivity : AppCompatActivity() {


    // Progress
    lateinit var progressBar: ProgressBar
    lateinit var tVpB: TextView
    var progressValue = 0

    // question
    lateinit var questionTV: TextView
    lateinit var imageView: ImageView
    val answersTV = mutableListOf<TextView>()
    lateinit var submitB: Button
    var isAnswered = false

    //other
    val randomOrder = generateSequence { Random.nextInt(0..2) }.distinct().take(3).toSet()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qa_questions)

        progressValue = intent.extras?.getInt("progressValue") ?: 0

        progressBar = findViewById(R.id.progressBar)
        tVpB = findViewById(R.id.textView3)

        questionTV = findViewById(R.id.textView)
        imageView = findViewById(R.id.imageView)
        answersTV.add(findViewById(R.id.textView4))
        answersTV.add(findViewById(R.id.textView5))
        answersTV.add(findViewById(R.id.textView6))
        answersTV.add(findViewById(R.id.textView7))
        submitB = findViewById(R.id.button6)

        initQuestion(QaConstants.questions[progressValue])
    }

    private fun initQuestion(question: QaQuestion) {
        val order = generateSequence { Random.nextInt(0..3) }.distinct().take(4).toList()

        questionTV.text = question.question
        imageView.setImageResource(question.image)
        progressBar.progress = progressValue + 1
        tVpB.text = "${progressBar.progress}/${progressBar.max}"
        for (i in 0..3) {
            answersTV[i].text = question.answer[order[i]]
        }
    }

    fun onAnswerTV(view: View) {
        val textView = view as TextView
        val clickerIndex = QaConstants.questions[progressValue].answer.indexOf(textView.text.toString())
        if (clickerIndex == 0) {
            textView.setBackgroundResource(R.drawable.right_answer)
        } else {
            textView.setBackgroundResource(R.drawable.wrong_answer)
            answersTV.stream().filter { i -> QaConstants.questions[progressValue].answer.indexOf(i.text.toString()) == 0 }.findFirst().get()
                .setBackgroundResource(R.drawable.right_answer)
        }
        isAnswered = true
    }

    fun onSubmitBtn(view: View) {
        if (!isAnswered) {
            Toast.makeText(this, "Mach ne Antwort, diggi!", Toast.LENGTH_LONG).show()
            return
        }

        if (progressBar.progress == progressBar.max) {
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show()
            return
        }


        val intent = Intent(this, QaQuestionsActivity::class.java).apply {
            putExtra("progressValue", progressValue + 1)
        }
        startActivity(intent)
        finish()
    }
}