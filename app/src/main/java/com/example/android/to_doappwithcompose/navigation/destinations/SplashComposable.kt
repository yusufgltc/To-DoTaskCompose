package com.example.android.to_doappwithcompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.android.to_doappwithcompose.ui.screens.splash.SplashScreen
import com.example.android.to_doappwithcompose.util.Constants.SPLASH_SCREEN

fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = SPLASH_SCREEN,
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}