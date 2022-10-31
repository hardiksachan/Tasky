package com.hardiksachan.tasky.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hardiksachan.tasky.models.Task
import com.hardiksachan.tasky.ui.theme.TaskyTheme

@Composable
fun TaskItem(
    task: Task,
    onToggleComplete: (Boolean) -> Unit,
    removeTask: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = task.completed, onCheckedChange = onToggleComplete)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = task.name, modifier = Modifier.weight(1f))
        IconButton(onClick = removeTask) {
            Icon(Icons.Default.Delete, "delete")
        }
    }
}

@Preview
@Composable
fun IncompleteTaskItemPreview() {
    TaskyTheme {
        TaskItem(
            Task(
                id = 1, name = "Sample Task", completed = false
            ), {}
        ) { }
    }
}

@Preview
@Composable
fun CompleteTaskItemPreview() {
    TaskyTheme {
        TaskItem(
            Task(
                id = 1, name = "Completed Sample Task", completed = true
            ), {}
        ) { }
    }
}