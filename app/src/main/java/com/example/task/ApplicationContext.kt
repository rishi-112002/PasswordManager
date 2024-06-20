package com.example.task

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.task.repository.Repository
import com.example.task.room.PasswordsDb
import com.example.task.viewMode.PasswordViewModel

@Composable
fun  ApplicationContext(){
    val context = LocalContext.current
    val db = PasswordsDb.getInstance(context)
    val repository = Repository(db)
    val myViewModel = PasswordViewModel(repository)
    PasswordManagerApp(viewModel = myViewModel)
}