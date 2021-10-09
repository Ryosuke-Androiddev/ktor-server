package com.example.route

import com.example.model.Vocabulary
import com.example.utility.Constants.BASE_URL
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

private val words = listOf(
    Vocabulary("Apple","A delicious fruit it looks like red or green","$BASE_URL/images/apple-removebg-preview.png"),
    Vocabulary("Banana","A delicious fruit it looks like Yellow","$BASE_URL/images/banana-removebg-preview.png"),
    Vocabulary("Peach","A delicious fruit it looks like pink","$BASE_URL/images/peach-removebg-preview.png"),
    Vocabulary("Grape","A delicious fruit it looks like purple","$BASE_URL/images/grape-removebg-preview.png"),
    Vocabulary("Orange","A delicious fruit it looks like orange","$BASE_URL/images/orange-removebg-preview.png"),
    Vocabulary("Pineapple","A delicious fruit it looks like red or yellow","$BASE_URL/images/pineapple-removebg-preview.png")
)

fun Route.randomVocabulary() {
    get("/randomwords") {
        call.respond(
            HttpStatusCode.OK,
            words
        )
    }
}