package com.example.task.repository

import com.example.task.room.PasswordEntity
import com.example.task.room.PasswordsDb

class Repository(private val passwordsDb: PasswordsDb) {
    suspend fun addPasswordToRoom(password: PasswordEntity) {
        passwordsDb.passwordDao().addPassword(password)
    }
    suspend fun updateToRoom(password: PasswordEntity) {
        passwordsDb.passwordDao().update(password)
    }
    suspend fun deletePasswordFromRoom(password: PasswordEntity) {
        passwordsDb.passwordDao().delete(password)
    }

    fun getAllPasswords() = passwordsDb.passwordDao().getAllPassword()
}