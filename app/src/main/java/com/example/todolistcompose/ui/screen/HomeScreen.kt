package com.example.todolistcompose.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolistcompose.data.Task
import com.example.todolistcompose.ui.component.TaskItem
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    taskList: MutableList<Task>
) {
    var input by remember { mutableStateOf("") }
    var taskId by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("To Do List") })
        }
    ) { padding ->

        Column(modifier = Modifier.padding(padding).padding(16.dp)) {

            Row {
                TextField(
                    value = input,
                    onValueChange = { input = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Tambah tugas") }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = {
                    if (input.isNotBlank()) {
                        taskList.add(Task(taskId++, input))
                        input = ""
                    }
                }) {
                    Text("Tambah")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(taskList) { task ->
                    TaskItem(
                        task = task,
                        onClick = {
                            navController.navigate("detail/${task.id}")
                        },
                        onDelete = {
                            taskList.remove(task)
                        }
                    )
                }
            }
        }
    }
}