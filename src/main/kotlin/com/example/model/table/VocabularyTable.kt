package com.example.model.table

import org.jetbrains.exposed.sql.Table


object VocabularyTable: Table() {

    val word = varchar("word",30)
    val meaning = varchar("meaning",512)
    val imageUrl = varchar("imageUrl",512)
    val isCorrect = bool("isCorrect")
    val roomId = integer("roomId")

    override val primaryKey: PrimaryKey = PrimaryKey(word)
}