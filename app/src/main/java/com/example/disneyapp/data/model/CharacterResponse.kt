package com.example.disneyapp.data.model


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("data")
    val data: List<CharacterDto>
)