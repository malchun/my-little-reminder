package my.little.reminder.tasks

import jakarta.inject.Singleton

@Singleton
class TaskService {

    private val tasks = listOf("firstTask", "secondTask")

    fun getAll(): List<String> = tasks
}