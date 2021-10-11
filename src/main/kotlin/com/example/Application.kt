package com.example

import io.ktor.application.*
import com.example.plugins.*
import com.example.db.DataFactory
import com.example.repository.VocabularyRepository
import io.ktor.locations.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalLocationsAPI
@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    DataFactory.init()
    val wordRepo = VocabularyRepository()

    configureLocation()

    configureRouting(wordRepo)
    configureSerialization()
    configureMonitoring()
}
