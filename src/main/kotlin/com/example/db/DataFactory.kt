package com.example.db

import com.example.model.table.RoomTable
import com.example.model.table.VocabularyTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.net.URI

object DataFactory {

    fun init(){
        Database.connect(hikari())
        transaction {
            SchemaUtils.create(RoomTable)
            SchemaUtils.create(VocabularyTable)
        }
    }

    fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = System.getenv("JDBC_DRIVER")
        //config.jdbcUrl = System.getenv("JDBC_DATABASE_URL")
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"

        val uri = URI(System.getenv("JDBC_DATABASE_URL"))
        val username = uri.userInfo.split(":").toTypedArray()[0]
        val password = uri.userInfo.split(":").toTypedArray()[1]

        config.jdbcUrl =
            "jdbc:postgresql://" + uri.host + ":" + uri.port + uri.path + "?sslmode=require" + "&user=$username&password=$password"

        config.validate()

        return HikariDataSource(config)
    }

    suspend fun <T> dbQuery(block: () -> T): T =
        withContext(Dispatchers.IO) {
            transaction { block() }
        }
}