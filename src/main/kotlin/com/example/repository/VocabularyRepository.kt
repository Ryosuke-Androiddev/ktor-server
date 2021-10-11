package com.example.repository

import com.example.db.DataFactory
import com.example.model.Room
import com.example.model.Vocabulary
import com.example.model.table.RoomTable
import com.example.model.table.VocabularyTable
import com.example.repository.dao.VocabularyDao
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class VocabularyRepository: VocabularyDao {

    override suspend fun getAllRoom(): List<Room> =
        DataFactory.dbQuery {
            RoomTable.selectAll().mapNotNull {
                resultRowToRoom(it)
            }
        }

    // mapNotNull は、リストで返してくれる便利な関数
    override suspend fun getWordListByRoomId(roomId: Int): List<Vocabulary> =
        DataFactory.dbQuery {
            VocabularyTable.select { VocabularyTable.roomId.eq(roomId) }
                .mapNotNull {
                    resultRowToVocabulary(it)
                }
        }

    private fun resultRowToRoom(resultRow: ResultRow?): Room?{
        if (resultRow == null){
            return null
        }
        return Room(
            roomId = resultRow[RoomTable.roomId],
            roomName = resultRow[RoomTable.roomName],
            description = resultRow[RoomTable.description],
            isStudying = resultRow[RoomTable.isStudying],
            isFinished = resultRow[RoomTable.isFinished]
        )
    }

    private fun resultRowToVocabulary(resultRow: ResultRow?): Vocabulary?{
        if (resultRow == null){
            return null
        }
        return Vocabulary(
            word = resultRow[VocabularyTable.word],
            meaning = resultRow[VocabularyTable.meaning],
            imageUrl = resultRow[VocabularyTable.imageUrl],
            isCorrect = resultRow[VocabularyTable.isCorrect],
            roomId = resultRow[VocabularyTable.roomId]
        )
    }
}