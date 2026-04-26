package com.example.todolistcompose.data

data class Task(
    val id: Int,
    val title: String,
    var isDone: Boolean = false
)