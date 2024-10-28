package com.timur.ewaapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.timur.ewaapp.data.local.converter.EpisodeConverter
import com.timur.ewaapp.data.local.converter.LocationConverter
import com.timur.ewaapp.data.local.converter.OriginConverter
import com.timur.ewaapp.data.local.dao.CharacterDao
import com.timur.ewaapp.data.local.entity.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    exportSchema = false,
    version = 1,
)
@TypeConverters(LocationConverter::class, OriginConverter::class, EpisodeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val characterDao: CharacterDao
}