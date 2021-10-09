package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Vocabulary(
    val word: String,
    val description: String,
    val imageUrl: String
)
