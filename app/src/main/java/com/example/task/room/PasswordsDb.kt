package com.example.task.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PasswordEntity::class], version = 1 , exportSchema = false)
abstract class PasswordsDb : RoomDatabase() {
    abstract fun passwordDao(): PasswordDao
companion object{
    @Volatile
    private  var INSTANCE: PasswordsDb? = null
    fun getInstance(context: Context):PasswordsDb{
        synchronized(this){
            var instance = INSTANCE
if (instance==null){
    instance = Room.databaseBuilder(
        context.applicationContext,
        PasswordsDb::class.java,
        "passwords_database"

    ).build()

}
            return  instance
        }
    }
}

}