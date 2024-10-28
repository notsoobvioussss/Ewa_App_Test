package com.timur.ewaapp.domain.model

import com.timur.ewaapp.data.local.entity.CharacterEntity
import com.timur.ewaapp.domain.Domain

data class Character(
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
) : Domain {
    override fun asData(): CharacterEntity = CharacterEntity(
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