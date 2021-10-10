package com.example.route

import com.example.model.Room
import com.example.model.Vocabulary
import com.example.model.table.RoomTable
import com.example.model.table.VocabularyTable
import com.example.repository.DatabaseConnection
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.ktorm.dsl.*

fun Route.getWords(){

    val db = DatabaseConnection.database

    route("/words"){

        get {
            val room = db.from(RoomTable).select()
                .map {
                    val roomId = it[RoomTable.roomId]
                    val roomName = it[RoomTable.roomName]
                    val description = it[RoomTable.description]
                    val isStudying = it[RoomTable.isStudying]
                    val isFinished = it[RoomTable.isFinished]
                    Room(
                        roomId = roomId ?: 0,
                        roomName = roomName ?: "",
                        description = description ?: "",
                        isStudying = isStudying ?: false,
                        isFinished = isFinished ?: false
                    )
                }
            call.respond(HttpStatusCode.OK,room)
        }

        get("/{roomId}") {
            val roomId = call.parameters["roomId"]?.toInt() ?: -1
            val words = db.from(VocabularyTable)
                .select()
                .where { VocabularyTable.roomId eq  roomId }
                .map {
                    val word = it[VocabularyTable.word]
                    val meaning = it[VocabularyTable.meaning]
                    val imageUrl = it[VocabularyTable.imageUrl]
                    val isCorrect = it[VocabularyTable.isCorrect]
                    val roomId = it[VocabularyTable.roomId]
                    Vocabulary(
                        word = word ?: "",
                        meaning = meaning ?: "",
                        imageUrl = imageUrl ?: "",
                        isCorrect = isCorrect ?: false,
                        roomId = roomId ?: 0
                    )
                }
            call.respond(HttpStatusCode.OK,words)
        }
    }
}