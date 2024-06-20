package com.example.task.bottom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.R
import com.example.task.room.PasswordEntity
import com.example.task.viewMode.PasswordViewModel

@Composable
fun ClickedPassword(passwordEntity: PasswordEntity?, onClose: () -> Unit, viewModel: PasswordViewModel) {
    var accountName by remember { mutableStateOf(passwordEntity?.accountName ?: "") }
    var username by remember { mutableStateOf(passwordEntity?.userName ?: "") }
    var password by remember { mutableStateOf(passwordEntity?.password ?: "") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Account Details",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 18.sp,
            color = Color.Blue,
        )

        OutlinedTextField(
            value = accountName,
            onValueChange = { accountName = it },
            label = { Text("Account Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = {  password= it},
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth() ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (!isPasswordVisible)
                    painterResource(id = R.drawable.icon_eye)
                else
                    painterResource(id = R.drawable.eye)
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(painter = image, contentDescription = if (isPasswordVisible) "Hide password" else "Show password")
                }
            }
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        passwordEntity?.let {
                            val updatedPassword = it.copy(
                                accountName = accountName,
                                userName = username,
                                password = password
                            )
                            viewModel.updatePassword(updatedPassword)
                            onClose()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F7DE3)),
                    enabled = isButtonEnabled,
                ) {
                    Text("Update")
                }
                Button(
                    onClick = {
                        passwordEntity?.let {
                            viewModel.deletePassword(it)
                            onClose()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF04646))
                ) {
                    Text("Delete")
                }
            }
        }
        LaunchedEffect(accountName, username, password) {
            if (passwordEntity != null) {
                isButtonEnabled = accountName != passwordEntity.accountName || username != passwordEntity.userName || password != passwordEntity.password
            }
        }
}}