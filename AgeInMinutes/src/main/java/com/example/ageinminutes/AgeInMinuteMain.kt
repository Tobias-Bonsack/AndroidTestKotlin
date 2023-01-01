package com.example.ageinminutes

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.abs

class AgeInMinuteMain : AppCompatActivity() {

    lateinit var datePickerFragment: DatePickerFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_in_minute_main)
        datePickerFragment = DatePickerFragment(this, Calendar.getInstance(), ::updateDate)

        findViewById<Button>(R.id.selectDateBtn).setOnClickListener(View.OnClickListener { view ->
            datePickerFragment.show()
        })
    }

    private fun updateDate() {
        findViewById<TextView>(R.id.textView4).text = datePickerFragment.getDateString()
        calculateMinutes()
    }

    private fun calculateMinutes(): Unit {
        val minuteTV = findViewById<TextView>(R.id.textView6)
        val cMinute = (Calendar.getInstance().timeInMillis / 60000).toInt()
        val theDate = abs(cMinute - (datePickerFragment.date.timeInMillis / 60000).toInt())
        minuteTV.text = theDate.toString()


    }
}