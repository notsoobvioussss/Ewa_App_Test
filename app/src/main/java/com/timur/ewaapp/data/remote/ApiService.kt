package com.timur.ewaapp.data.remote

import com.timur.ewaapp.domain.model.CharactersResponseFull
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ) : CharactersResponseFull
}