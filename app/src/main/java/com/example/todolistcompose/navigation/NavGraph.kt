package com.example.todolistcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.todolistcompose.data.Task
import com.example.todolistcompose.ui.screen.DetailScreen
import com.example.todolistcompose.ui.screen.HomeScreen

@Composable
fun AppNavGraph(taskList: MutableList<Task>) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController, taskList)
        }

        composable("detail/{taskId}") { backStackEntry ->
            val id = backStackEntry.arguments
                ?.getString("taskId")
                ?.toInt()

            DetailScreen(id, taskList)
        }
    }
}