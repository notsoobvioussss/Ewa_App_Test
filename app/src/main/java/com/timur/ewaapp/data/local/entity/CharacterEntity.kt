package com.timur.ewaapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.timur.ewaapp.domain.Data
import com.timur.ewaapp.domain.model.Character
import com.timur.ewaapp.domain.model.Location
import com.timur.ewaapp.domain.model.Origin

@Entity
data class CharacterEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
): Data {
    override fun asDomain(): Character = Character(
        id,
        name,
        status,
        species,
        type,
        gender,
        origin,
        location,
        image,
        episode,
        url,
        created
    )

}