package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Vocabulary(
    val word: String,
    val meaning: String,
    val imageUrl: String,
    var isCorrect: Boolean = false,
    var roomId: Int
)
