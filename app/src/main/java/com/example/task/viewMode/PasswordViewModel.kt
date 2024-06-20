package com.example.task.viewMode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.repository.Repository
import com.example.task.room.PasswordEntity
import kotlinx.coroutines.launch

class PasswordViewModel(private val repository: Repository):ViewModel() {
    fun addPassword(password:PasswordEntity) {
    viewModelScope.launch {
        repository.addPasswordToRoom(password)
    }
    }
    fun updatePassword(passwordEntity: PasswordEntity) {
        viewModelScope.launch {
            repository.updateToRoom(passwordEntity)
        }
    }

    fun deletePassword(passwordEntity: PasswordEntity) {
        viewModelScope.launch {
            repository.deletePasswordFromRoom(passwordEntity)
        }
    }
    val passwords = repository.getAllPasswords()
    }

