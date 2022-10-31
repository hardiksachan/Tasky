package com.hardiksachan.tasky.data

import com.hardiksachan.tasky.models.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TaskStore {
    private val _tasks: MutableStateFlow<List<Task>> = MutableStateFlow(listOf())
    val tasks: StateFlow<List<Task>> = _tasks

    private var latestId = 0

    private fun getId(): Int {
        latestId++
        return latestId
    }


    fun addTask(name: String) {
        val newTask = Task(
            getId(),
            name,
            false
        )

        _tasks.update { oldTasks -> listOf(newTask, *oldTasks.toTypedArray()) }
    }

    fun toggleCompleted(taskId: Int, completed: Boolean) {
        _tasks.update { tasks ->
            tasks.map { task ->
                if (task.id == taskId) {
                    task.copy(id = task.id, name = task.name, completed = completed)
                } else task
            }
        }
    }

    fun removeTask(taskId: Int) {
        _tasks.update { tasks ->
            tasks.filter { it.id != taskId }
        }
    }

    fun deleteCompletedTasks() {
        _tasks.update { tasks ->
            tasks.filter { !it.completed }
        }
    }
}