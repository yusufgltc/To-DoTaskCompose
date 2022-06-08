package com.example.android.to_doappwithcompose.ui.screens.list

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.to_doappwithcompose.ui.theme.topAppBarBackground
import com.example.android.to_doappwithcompose.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar() {
    DefaultListAppBar()
}

@Composable
fun DefaultListAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackground
    )
}


@Preview(name = "LightMode")
@Preview(name = "DarkMode", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultListAppBarPrev() {
    DefaultListAppBar()
}