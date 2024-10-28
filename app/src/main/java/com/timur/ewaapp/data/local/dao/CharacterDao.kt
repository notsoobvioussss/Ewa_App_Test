package com.timur.ewaapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.timur.ewaapp.data.local.entity.CharacterEntity

@Dao
interface CharacterDao {

    @Query("select * from characterentity limit 20 offset :offset")
    suspend fun getCharacters(offset: Int): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun setCharacters(meals: List<CharacterEntity>)
}