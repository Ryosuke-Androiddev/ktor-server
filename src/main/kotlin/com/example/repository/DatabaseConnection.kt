package com.example.repository

import org.ktorm.database.Database

object DatabaseConnection {

    val database = Database.connect(
        url = "jdbc:mysql://localhost:3306/ktor_word",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "MySQL0819NRyoSagaU23!"
    )
}