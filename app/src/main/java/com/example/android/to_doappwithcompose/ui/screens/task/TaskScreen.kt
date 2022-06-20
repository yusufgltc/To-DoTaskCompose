package com.example.android.to_doappwithcompose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.android.to_doappwithcompose.data.models.Priority
import com.example.android.to_doappwithcompose.data.models.ToDoTask
import com.example.android.to_doappwithcompose.ui.veiwmodels.SharedViewModel
import com.example.android.to_doappwithcompose.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                navigateToListScreen = navigateToListScreen,
                selectedTask = selectedTask
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = { sharedViewModel.title.value = it },
                description = description,
                onDescriptionChange = { sharedViewModel.description.value = it },
                priority = priority,
                onPrioritySelected = {sharedViewModel.priority.value = it}
            )
        }
    )
}