package com.example.disneyapp.data.repository

import com.example.disneyapp.data.remote.ApiService
import com.example.disneyapp.domain.model.Character
import com.example.disneyapp.domain.repository.CharacterRepository
import com.example.disneyapp.utils.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): CharacterRepository {
    override suspend fun getCharacters(): Flow<List<Character>> = flow {
         val response = apiService.getCharacters()
        if (response.isSuccessful) {
            response.body()?.let {
                emit(it.data.map { dto -> dto.toDomain() })
            }
        } else {
            throw Exception("Error fetching characters")
        }
    }.flowOn(Dispatchers.IO)
}