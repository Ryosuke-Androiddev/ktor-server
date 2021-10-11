package com.example.model.table

import org.jetbrains.exposed.sql.Table

object UserTable: Table() {

    val name = varchar("name",30)
    val age = integer("age")

    override val primaryKey: PrimaryKey = PrimaryKey(name)
}