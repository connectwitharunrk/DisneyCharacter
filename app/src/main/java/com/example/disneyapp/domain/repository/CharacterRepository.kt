package com.example.disneyapp.domain.repository

import com.example.disneyapp.core.util.Resource
import com.example.disneyapp.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(): Flow<Resource<List<Character>>>
}