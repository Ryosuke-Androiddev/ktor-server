package com.example.repository

import com.example.model.table.User
import com.example.model.table.UserTable
import org.jetbrains.exposed.sql.ResultRow

class Repo {



    private fun rowToUser(row: ResultRow?): User?{
        if (row == null){
            return null
        }

        return User(
            name = row[UserTable.name],
            age = row[UserTable.age]
        )
    }
}