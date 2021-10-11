package com.example.route


import com.example.repository.VocabularyRepository
import com.example.utility.Constants.GET_ROOM
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
@Location(GET_ROOM)
class GetRoom

@KtorExperimentalLocationsAPI
fun Route.getWords(
    wordRepo: VocabularyRepository
){

    get<GetRoom> {

        try {
            val roomList = wordRepo.getAllRoom()
            call.respond(HttpStatusCode.OK,roomList)
        } catch (e: Throwable) {
            call.respondText("${e.message}")
        }
    }

    get("$GET_ROOM/{roomId}") {
        val roomId = call.parameters["roomId"] ?: return@get call.respondText("Nothing", status = HttpStatusCode.Unauthorized)

        //受け取ったパラメータを数字に直す必要がある
        val wordList = wordRepo.getWordListByRoomId(roomId.toInt())
        try {
            if (wordList.isEmpty()){
                call.respondText("Not Found")
            } else {
                call.respond(HttpStatusCode.OK,wordList)
            }
        } catch (e: Throwable){
            call.respondText("${e.message}")
        }
    }
}