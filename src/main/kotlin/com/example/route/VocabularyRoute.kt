package com.example.route

import com.example.model.Vocabulary
import com.example.utility.Constants.BASE_URL
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

private val words = listOf(
    Vocabulary("Apple","A delicious fruit it looks like red or green","$BASE_URL/images/apple.png"),
    Vocabulary("Banana","A delicious fruit it looks like Yellow","$BASE_URL/images/banana.png"),
    Vocabulary("Peach","A delicious fruit it looks like pink","$BASE_URL/images/peach.png"),
    Vocabulary("Grape","A delicious fruit it looks like purple","$BASE_URL/images/grape.png"),
    Vocabulary("Orange","A delicious fruit it looks like orange","$BASE_URL/images/orange.png"),
    Vocabulary("Pineapple","A delicious fruit it looks like red or yellow","$BASE_URL/images/pineapple.png")
)

fun Route.randomVocabulary() {
    get("/randomwords") {
        call.respond(
            HttpStatusCode.OK,
            words
        )
    }
}