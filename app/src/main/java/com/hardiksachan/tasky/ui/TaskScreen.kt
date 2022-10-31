package com.hardiksachan.tasky.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hardiksachan.tasky.models.Task

@Composable
fun TaskScreen(
    tasks: List<Task>,
    addTask: (String) -> Unit,
    removeTask: (Task) -> Unit,
    onCompleteToggled: (Task, Boolean) -> Unit,
    deleteCompletedTasks: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TaskInput(addTask = addTask)
            TaskList(
                tasks = tasks,
                onCompleteToggled = onCompleteToggled,
                removeTask = removeTask,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = { deleteCompletedTasks() }) {
                Text("Delete Completed Tasks")
            }
        }
    }
}