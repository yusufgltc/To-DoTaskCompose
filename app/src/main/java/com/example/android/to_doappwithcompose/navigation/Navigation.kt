package com.example.android.to_doappwithcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.android.to_doappwithcompose.navigation.destinations.listComposable
import com.example.android.to_doappwithcompose.navigation.destinations.taskComposable
import com.example.android.to_doappwithcompose.ui.veiwmodels.SharedViewModel
import com.example.android.to_doappwithcompose.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(navigateToTaskScreen = screen.task, sharedViewModel = sharedViewModel)
        taskComposable(navigateToListScreen = screen.list)
    }
}