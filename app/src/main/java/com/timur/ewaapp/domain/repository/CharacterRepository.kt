package com.timur.ewaapp.domain.repository

import com.timur.ewaapp.domain.model.Character

interface CharacterRepository {
    suspend fun getAllCharacters(page: Int = 1): List<Character>
}