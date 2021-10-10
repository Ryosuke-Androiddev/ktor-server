package com.example.repository.dao

import com.example.model.Room
import com.example.model.Vocabulary

interface VocabularyDao {

    suspend fun getVocabulary(): List<Vocabulary>

    suspend fun getAllRoom(): List<Room>
}