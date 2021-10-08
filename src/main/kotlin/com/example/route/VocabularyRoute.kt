package com.example.route

import com.example.model.Vocabulary
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

private val words = listOf(
    Vocabulary("Apple","A delicious fruit it looks like red or green, I like it!"),
    Vocabulary("Banana","A delicious fruit it looks like red or green, I like it!"),
    Vocabulary("Peach","A delicious fruit it looks like red or green, I like it!"),
    Vocabulary("Grape","A delicious fruit it looks like red or green, I like it!"),
    Vocabulary("Orange","A delicious fruit it looks like red or green, I like it!"),
    Vocabulary("Pain","A delicious fruit it looks like red or green, I like it!")
)

fun Route.randomVocabulary() {
    get("/randomwords") {
        call.respond(
            HttpStatusCode.OK,
            words.random()
        )
    }
}