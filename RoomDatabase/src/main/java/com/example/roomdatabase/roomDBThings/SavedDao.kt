package com.example.roomdatabase.roomDBThings

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedDao {

    @Insert
    suspend fun insert(entity: SavedEntity)

    @Update
    suspend fun update(entity: SavedEntity)

    @Delete
    suspend fun delete(entity: SavedEntity)

    @Query("select * from `saved-entity`")
    fun fetchAll(): Flow<List<SavedEntity>>

    @Query("select * from `saved-entity` where id=:id")
    fun fetchSavedById(id: Int): Flow<SavedEntity>
}