package com.hardiksachan.tasky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.hardiksachan.tasky.data.TaskStore
import com.hardiksachan.tasky.ui.TaskScreen
import com.hardiksachan.tasky.ui.theme.TaskyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val taskStore = TaskStore()

        setContent {
            TaskyTheme {
                val tasks = taskStore.tasks.collectAsState()

                TaskScreen(
                    tasks = tasks.value,
                    addTask = { taskStore.addTask(it) },
                    onCompleteToggled = { task, completed ->
                        taskStore.toggleCompleted(
                            task.id,
                            completed
                        )
                    },
                    removeTask = { taskStore.removeTask(it.id) },
                    deleteCompletedTasks = { taskStore.deleteCompletedTasks() }
                )
            }
        }
    }
}