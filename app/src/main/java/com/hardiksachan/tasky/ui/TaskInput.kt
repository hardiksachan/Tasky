package com.hardiksachan.tasky.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hardiksachan.tasky.ui.theme.TaskyTheme

@Composable
fun TaskInput(
    addTask: (String) -> Unit
) {
    var value by remember {
        mutableStateOf("")
    }

    TextField(
        value = value,
        onValueChange = { value = it },
        placeholder = {1
            Text("New Task")
        },
        trailingIcon = {
            IconButton(onClick = {
                addTask(value)
                value = ""
            }) {
                Icon(Icons.Default.Done, "done")
            }
        },
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun TaskInputPreview() {
    TaskyTheme {
        TaskInput() {

        }
    }
}