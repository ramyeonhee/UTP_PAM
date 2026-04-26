package com.example.todolistcompose.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolistcompose.data.Task

@Composable
fun DetailScreen(
    taskId: Int?,
    taskList: MutableList<Task>
) {
    val task = taskList.find { it.id == taskId }

    task?.let {
        Column(modifier = Modifier.padding(16.dp)) {

            Text("Judul: ${it.title}", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Status: ${if (it.isDone) "Selesai" else "Belum"}")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                it.isDone = true
            }) {
                Text("Tandai Selesai")
            }
        }
    }
}