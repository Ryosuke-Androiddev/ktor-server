package com.example

import io.ktor.application.*
import com.example.plugins.*
import io.ktor.locations.*
import org.ktorm.database.Database

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalLocationsAPI
@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    //configureRouting()
    configureSerialization()
    configureMonitoring()
}
