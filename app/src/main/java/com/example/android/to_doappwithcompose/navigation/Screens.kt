package com.example.android.to_doappwithcompose.navigation

import androidx.navigation.NavHostController
import com.example.android.to_doappwithcompose.util.Action
import com.example.android.to_doappwithcompose.util.Constants.LIST_SCREEN
import com.example.android.to_doappwithcompose.util.Constants.SPLASH_SCREEN

class Screens(navController: NavHostController) {

    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION}"){
            popUpTo(SPLASH_SCREEN) {inclusive = true}
        }
    }

    val list: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }

    val task: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
}