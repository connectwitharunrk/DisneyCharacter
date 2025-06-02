package com.example.disneyapp.data.repository

import com.example.disneyapp.core.util.Resource
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
    override suspend fun getCharacters(): Flow<Resource<List<Character>>> = flow {
        emit(Resource.Loading)
        val response = apiService.getCharacters()
        if (response.isSuccessful) {
            val body = response.body()
            if(body != null) {
                emit(Resource.Success(body.data.map { it.toDomain() }))
            } else {
                emit(Resource.Error("No data found"))
            }
        } else {
            emit(Resource.Error("Something went wrong"))
        }
    }.flowOn(Dispatchers.IO)
}