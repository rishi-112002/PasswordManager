package com.example.task.room

import android.view.View
import android.view.autofill.AutofillId
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PasswordEntity(
    @PrimaryKey
val id :Int = View.generateViewId(),
    val password:String,
    val accountName: String,
    val userName: String,

    )
