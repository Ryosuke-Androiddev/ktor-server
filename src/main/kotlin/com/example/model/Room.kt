package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Room(
    val roomId: Int,
    val roomName: String,
    val description: String,
    var isStudying: Boolean,
    var isFinished: Boolean
)