package com.example.model.table

import com.example.model.table.VocabularyTable.primaryKey
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object RoomTable: Table<Nothing>("room") {

    val roomId = int("roomId").primaryKey()
    val roomName = varchar("roomName")
    val description = varchar("description")
    var isStudying = boolean("isStudying")
    var isFinished = boolean("isFinished")
}