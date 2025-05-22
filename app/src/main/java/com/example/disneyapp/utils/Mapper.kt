package com.example.disneyapp.utils

import com.example.disneyapp.data.model.CharacterDto
import com.example.disneyapp.domain.model.Character


fun CharacterDto.toDomain(): Character {
    return Character(
        name = name,
        imageUrl = imageUrl
    )
}
