package com.example.disneyapp.domain.usecase

import com.example.disneyapp.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke() = repository.getCharacters()
}