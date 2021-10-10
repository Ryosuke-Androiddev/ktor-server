package com.example.route

import com.example.model.Vocabulary
import com.example.model.table.VocabularyTable
import com.example.repository.DatabaseConnection
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select

fun Route.getWords(){

    val db = DatabaseConnection.database

    route("/"){
        get {
            val words = db.from(VocabularyTable).select()
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