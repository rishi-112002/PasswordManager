package com.example.task.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PasswordDao {
    @Insert
    suspend fun addPassword(passwordEntity: PasswordEntity)
@Query("SELECT * FROM PasswordEntity")
 fun getAllPassword(): Flow<List<PasswordEntity>>



    @Query("SELECT * from PasswordEntity where id = :id")
    fun getById(id: Int): PasswordEntity?

    @Insert
    suspend fun insert(item: PasswordEntity)

    @Update
    suspend fun update(item: PasswordEntity)

    @Delete
    suspend fun delete(item: PasswordEntity)

    @Query("DELETE FROM PasswordEntity")
    suspend fun deleteAllTodos()
}