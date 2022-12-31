package com.example.ageinminutes

import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class DatePickerFragment(context: Context, c: Calendar, toExecute: () -> Unit) : DatePickerDialog(
    context, null, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(
        Calendar.DAY_OF_MONTH)), DatePickerDialog.OnDateSetListener {

    var date: Calendar = Calendar.getInstance()
        private set
    private val method = toExecute

    init {
        this.setOnDateSetListener(this)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        date.set(p1, p2, p3)
        method()
    }

    fun getDateString(): String {
        return "" + date.get(Calendar.DAY_OF_MONTH) + "." + date.get(Calendar.MONTH) + "." + date.get(Calendar.YEAR)
    }

}
