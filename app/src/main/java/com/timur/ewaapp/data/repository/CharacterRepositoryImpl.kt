package com.timur.ewaapp.data.repository

import com.timur.ewaapp.data.local.dao.CharacterDao
import com.timur.ewaapp.data.remote.ApiService
import com.timur.ewaapp.domain.model.Character
import com.timur.ewaapp.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val apiService: ApiService,
    private val characterDao: CharacterDao
) : CharacterRepository {
    override suspend fun getAllCharacters(page: Int): List<Character> {
        val data = characterDao.getCharacters((page - 1) * 20)
            .map { it.asDomain() }
            .ifEmpty {
                val apiData = apiService.getAllCharacters(page).results
                characterDao.setCharacters(apiData.map { it.asData() })
                apiData
            }
        return data
    }
}