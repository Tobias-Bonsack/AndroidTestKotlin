package com.example.roomdatabase.roomDBThings

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved-entity")
data class SavedEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val firstValue: String = "",
    @ColumnInfo(name = "column-info-second") val secondValue: String = ""
)
