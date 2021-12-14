package my.little.reminder.tasks

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/task")
class TaskController (private val taskService: TaskService) {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun getAll() = taskService.getAll()
}