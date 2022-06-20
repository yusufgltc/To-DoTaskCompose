@file:OptIn(ExperimentalMaterialApi::class)

package com.example.android.to_doappwithcompose.ui.screens.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.to_doappwithcompose.data.models.Priority
import com.example.android.to_doappwithcompose.data.models.ToDoTask
import com.example.android.to_doappwithcompose.ui.theme.*
import com.example.android.to_doappwithcompose.util.RequestState

@ExperimentalMaterialApi
@Composable
fun ListContent(
    tasks: RequestState<List<ToDoTask>> ,
    navigationToTaskScreen: (taskId: Int) -> Unit
) {
   if (tasks is RequestState.Success) {
       if (tasks.data.isEmpty()){
           EmptyContent()
       } else {
           DisplayTasks(
               tasks = tasks.data,
               navigationToTaskScreen = navigationToTaskScreen
           )
       }
   }
}
@ExperimentalMaterialApi
@Composable
fun DisplayTasks(
    tasks: List<ToDoTask>,
    navigationToTaskScreen: (taskId: Int) -> Unit
) {
    LazyColumn {
        this.items(
            items = tasks,
            key = { task ->
                task.id
            }
        ) { task ->
            TaskItem(
                toDoTask = task,
                navigationToTaskScreen = navigationToTaskScreen
            )
        }
    }
}

@Composable
fun TaskItem(
    toDoTask: ToDoTask,
    navigationToTaskScreen: (taskId: Int) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.taskItemBackgroundColor,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
        onClick = {
            navigationToTaskScreen(toDoTask.id)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(all = LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = toDoTask.title,
                    color = MaterialTheme.colors.taskItemTextColor,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.TopEnd

                ) {
                    Canvas(
                        modifier = Modifier
                            .size(PRIORITY_INDICATOR_SIZE)
                    ) {
                        drawCircle(
                            color = toDoTask.priority.color
                        )
                    }
                }
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = toDoTask.description,
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun TaskItemPreview() {
    TaskItem(
        toDoTask = ToDoTask(
            id = 0,
            title = "Title",
            description = "Some random text",
            priority = Priority.MEDIUM
        ),
        navigationToTaskScreen = {}
    )
}