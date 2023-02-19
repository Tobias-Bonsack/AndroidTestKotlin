package com.example.roomdatabase.roomDBThings

import android.app.Application

class SavedApp: Application() {
    val db by lazy { SavedDB.getInstance(this) }
}