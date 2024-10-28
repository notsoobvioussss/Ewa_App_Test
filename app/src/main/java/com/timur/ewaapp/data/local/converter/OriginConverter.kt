package com.timur.ewaapp.data.local.converter

import androidx.room.TypeConverter
import com.timur.ewaapp.domain.model.Origin

class OriginConverter {
    @TypeConverter
    fun fromOrigin(value: Origin): String = "${value.name}||${value.url}"

    @TypeConverter
    fun toOrigin(value: String): Origin = Origin(
        value.split("||")[0],
        value.split("||")[1]
    )

}