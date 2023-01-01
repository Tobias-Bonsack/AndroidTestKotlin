package com.example.ageinminutes

import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs

class AgeInMinuteMain : AppCompatActivity() {

    private lateinit var datePickerFragment: DatePickerFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_in_minute_main)
        datePickerFragment = DatePickerFragment(this, Calendar.getInstance(), ::updateDate)

        findViewById<Button>(R.id.selectDateBtn).setOnClickListener {
            datePickerFragment.show()
        }
    }

    private fun updateDate() {
        findViewById<TextView>(R.id.textView4).text = datePickerFragment.getDateString()
        calculateMinutes()
    }

    private fun calculateMinutes() {
        val minuteTV = findViewById<TextView>(R.id.textView6)
        val cMinute = (Calendar.getInstance().timeInMillis / 60000).toInt()
        val theDate = abs(cMinute - (datePickerFragment.date.timeInMillis / 60000).toInt())
        minuteTV.text = theDate.toString()


    }
}