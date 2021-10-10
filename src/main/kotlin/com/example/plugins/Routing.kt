package com.example.plugins

import com.example.route.getWords
import io.ktor.routing.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.locations.*

@KtorExperimentalLocationsAPI
fun Application.configureRouting() {

    routing {
        getWords()
        // Static plugin. Try to access `/static/index.html`
        static{
            resources("static")
        }
    }
}
