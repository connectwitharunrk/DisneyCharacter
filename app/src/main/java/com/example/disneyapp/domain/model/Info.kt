package com.example.disneyapp.domain.model


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count")
    val count: Int,
    @SerializedName("nextPage")
    val nextPage: String,
    @SerializedName("previousPage")
    val previousPage: Any,
    @SerializedName("totalPages")
    val totalPages: Int
)