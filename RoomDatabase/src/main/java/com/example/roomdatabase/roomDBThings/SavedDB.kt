package com.example.roomdatabase.roomDBThings

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SavedEntity::class], version = 1)
abstract class SavedDB : RoomDatabase() {

    abstract fun savedDao(): SavedDao

    companion object {
        @Volatile
        private lateinit var INSTANCE: SavedDB

        fun getInstance(context: Context): SavedDB {
            synchronized(this) {
                if (!this::INSTANCE.isInitialized) {
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext, SavedDB::class.java, "saved-database").fallbackToDestructiveMigration()
                            .build()
                }
                return INSTANCE
            }

        }
    }

}