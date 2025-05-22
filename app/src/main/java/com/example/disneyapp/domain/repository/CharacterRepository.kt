package com.example.disneyapp.domain.repository

import com.example.disneyapp.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(): Flow<List<Character>>
}