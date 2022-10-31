package com.hardiksachan.tasky.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hardiksachan.tasky.models.Task
import com.hardiksachan.tasky.ui.theme.TaskyTheme

@Composable
fun TaskList(
    tasks: List<Task>,
    onCompleteToggled: (Task, Boolean) -> Unit,
    removeTask: (Task) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = tasks,
            key = { it.id }
        ) { task ->
            TaskItem(
                task = task,
                onToggleComplete = { onCompleteToggled(task, it) },
                removeTask = { removeTask(task) }
            )
        }
    }
}

@Preview
@Composable
fun TaskListPreview() {
    TaskyTheme {
        TaskList(
            listOf(
                Task(
                    id = 1, name = "Completed Sample Task", completed = true
                ), Task(
                    id = 2, name = "Sample Task", completed = false
                )
            ),
            { _, _ -> }, {}
        )
    }
}