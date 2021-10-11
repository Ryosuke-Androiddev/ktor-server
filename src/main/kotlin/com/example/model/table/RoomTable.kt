package com.example.model.table

import org.jetbrains.exposed.sql.Table


object RoomTable: Table() {

    val roomId = integer("roomId")
    val roomName = varchar("roomName",30)
    val description = varchar("description",512)
    var isStudying = bool("isStudying")
    var isFinished = bool("isFinished")

    override val primaryKey: PrimaryKey = PrimaryKey(roomId)
}