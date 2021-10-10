package com.example.model.table

import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object VocabularyTable: Table<Nothing>("vocabulary") {

    val word = varchar("word").primaryKey()
    val meaning = varchar("meaning")
    val imageUrl = varchar("imageUrl")
    val isCorrect = boolean("isCorrect")
    val roomId = int("roomId")
}