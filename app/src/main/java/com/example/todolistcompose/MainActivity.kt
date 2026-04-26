package com.example.todolistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.todolistcompose.data.Task
import com.example.todolistcompose.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val taskList = remember {
                mutableStateListOf<Task>()
            }

            AppNavGraph(taskList)
        }
    }
}