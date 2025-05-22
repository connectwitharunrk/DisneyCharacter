package com.example.disneyapp.data.model


import com.google.gson.annotations.SerializedName

data class InfoDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("nextPage")
    val nextPage: String,
    @SerializedName("previousPage")
    val previousPage: Any,
    @SerializedName("totalPages")
    val totalPages: Int
)