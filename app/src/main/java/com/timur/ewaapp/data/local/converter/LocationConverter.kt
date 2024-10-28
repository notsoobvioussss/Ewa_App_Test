package com.timur.ewaapp.data.local.converter

import androidx.room.TypeConverter
import com.timur.ewaapp.domain.model.Location

class LocationConverter {
    @TypeConverter
    fun fromLocation(value: Location): String = "${value.name}||${value.url}"

    @TypeConverter
    fun toLocation(value: String): Location = Location(
        value.split("||")[0],
        value.split("||")[1]
    )

}