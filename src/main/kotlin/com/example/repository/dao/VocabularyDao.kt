package com.example.repository.dao

import com.example.model.Room
import com.example.model.Vocabulary

interface VocabularyDao {

    suspend fun getAllRoom(): List<Room>

    suspend fun getWordListByRoomId(roomId: Int): List<Vocabulary>
}