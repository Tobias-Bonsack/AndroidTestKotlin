package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CalculatorMainActivity : AppCompatActivity() {

    lateinit var result: TextView

    private var currentNumber = 0
    private var lastNumber = 1
    private var operator: Operation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator_main)
        result = findViewById<TextView>(R.id.textViewResult)

    }

    fun onDigit(view: View) {
        val numberPressed = (view as Button).text.toString().toInt()
        if (currentNumber == 0 && numberPressed == 0) {
            return
        } else if (currentNumber == 0) {
            result.text = numberPressed.toString()
            currentNumber = numberPressed
        } else {
            result.append(numberPressed.toString())
            currentNumber = currentNumber * 10 + numberPressed
        }

    }

    fun onOperation(view: View) {
        when (val operationString = (view as Button).text.toString()) {
            "CLR" -> {
                currentNumber = 0
                result.text = "0"
                lastNumber = 0
            }
            "=" -> {
                try {
                    val calcResult = operator?.calculate(lastNumber, currentNumber) ?: 0
                    result.text = calcResult.toString()
                    currentNumber = calcResult
                    lastNumber = 0
                    operator = null
                } catch (e: java.lang.Exception) {
                    currentNumber = 0
                    result.text = "0"
                    lastNumber = 0
                    operator = null
                    Toast.makeText(applicationContext, "Some Error occures!", Toast.LENGTH_LONG).show()
                }
            }
            else -> {
                operator = Operation from operationString
                lastNumber = currentNumber
                currentNumber = 0
                result.text = currentNumber.toString()
            }
        }
    }

    enum class Operation(val value: String) {
        PLUS("+") {
            override fun calculate(a: Int, b: Int) = a + b
        },
        MINUS("-") {
            override fun calculate(a: Int, b: Int) = a - b
        },
        DIVIDE("/") {
            override fun calculate(a: Int, b: Int) = a / b
        },
        MULTIPLY("/") {
            override fun calculate(a: Int, b: Int) = a * b
        };

        abstract fun calculate(a: Int, b: Int): Int

        companion object {
            infix fun from(value: String): Operation? = Operation.values().firstOrNull { it.value == value }
        }
    }

}