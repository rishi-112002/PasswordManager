package com.example.task.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
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
import kotlin.random.Random

@Composable
fun AddEntryContent(onClose: () -> Unit ,viewModel: PasswordViewModel) {
    var accountName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val passwordStrength by remember { derivedStateOf { assessPasswordStrength(password) } }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(text = "Add New Entry", style = MaterialTheme.typography.bodyLarge , fontSize = 18.sp)

        OutlinedTextField(
            value =accountName,
            onValueChange = {  accountName= it},
            label = { Text("Account Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

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
        PasswordStrengthMeter(strength = passwordStrength)
        Box {
             Alignment.Center
            Button(

                onClick = {
                    if (accountName.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                        viewModel.addPassword(password = PasswordEntity(accountName = accountName, userName = username, password = password))
                        onClose()
                    }
                },
                enabled = isButtonEnabled,
            ) {
                Text("Add New Account")
            }
        }
        LaunchedEffect(accountName, username, password) {
            isButtonEnabled = accountName.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()
        }
    }

    }

fun assessPasswordStrength(password: String): PasswordStrength {
    var strength = 0
    if (password.length >= 8) strength++
    if (password.any { it.isDigit() }) strength++
    if (password.any { it.isUpperCase() }) strength++
    if (password.any { it.isLowerCase() }) strength++
    if (password.any { !it.isLetterOrDigit() }) strength++
    return PasswordStrength.entries[strength]
}

enum class PasswordStrength(val color: Color, val description: String) {
    WEAK(Color.Red, "Weak"),
    FAIR(Color.Yellow, "Fair"),
    GOOD(Color.Green, "Good"),
    STRONG(Color.Blue, "Strong"),
    VERY_STRONG(Color.Magenta, "Very Strong")
}

@Composable
fun PasswordStrengthMeter(strength: PasswordStrength) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Text(
            text = "Strength: ${strength.description}",
            color = strength.color,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
        Box(
            modifier = Modifier
                .height(8.dp)
                .background(strength.color)
                .weight(1f)
        )
    }

}

