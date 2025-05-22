package com.example.disneyapp.data.remote

import com.example.disneyapp.data.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>
}