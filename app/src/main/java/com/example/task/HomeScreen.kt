package com.example.task

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.bottom.AddEntryContent
import com.example.task.bottom.ClickedPassword
import com.example.task.room.PasswordEntity
import com.example.task.viewMode.PasswordViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun PasswordManagerApp(viewModel:PasswordViewModel) {
    var selectedPassword by remember { mutableStateOf<PasswordEntity?>(null) }
    val password by viewModel.passwords.collectAsState(initial = emptyList())
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    Surface(color = Color.White) {
        Box(modifier = Modifier.fillMaxSize()) {
        Column {
            TopAppBar(
                title = { Text("Password Manager", color = Color.Black) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
            if (password.isEmpty()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "No Password Found")

                }
            } else {
                LazyColumn(modifier = Modifier.fillMaxHeight().padding(bottom = 64.dp)) {
                    items(password) { passwords ->
                        PasswordEntry(passwords.accountName) {
                            selectedPassword = passwords
                            showBottomSheet = true
                        }
                    }
                }
            }
        }
            AddEntryButton(onClose = {
                selectedPassword = null
                showBottomSheet = true
            } ,
                modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp))

            if (showBottomSheet) {
                ModalBottomSheet(
                    sheetState = sheetState,
                    onDismissRequest = {
                        showBottomSheet = false
                    }
                ) {
                    if (selectedPassword != null) {
                        ClickedPassword(
                            passwordEntity = selectedPassword,
                            onClose = { showBottomSheet = false },
                            viewModel
                        )
                    } else {
                        AddEntryContent(
                            onClose = { showBottomSheet = false },
                            viewModel = viewModel
                        )
                    }
                }
            }

            }
    }
}

@Composable
fun PasswordEntry(text: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Row {
            val customStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)

            Text(
                text = text,
                style = customStyle,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(0.4F),
            )
            Spacer(modifier = Modifier.weight(0.1f))
            Text(text = "*******", color = Color.Gray, modifier = Modifier.padding(10.dp))
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "Navigate to password entry", modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun AddEntryButton(onClose: () -> Unit , modifier: Modifier) {
    val containerColor = Color(0xFF3F7DE3)
    Row(
        modifier = modifier,

        horizontalArrangement = Arrangement.End
    ) {
        FloatingActionButton(
            onClick = onClose,
            contentColor = MaterialTheme.colorScheme.background,
            containerColor = containerColor,

        ) {
            Icon(Icons.Rounded.Add, contentDescription = "Add new password entry")
        }
    }
}