package my.little.reminder.tasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TaskServiceTest {

    var sut: TaskService = TaskService()

    @Test
    fun `getAll returns all tasks`() {
        // when
        val result = sut.getAll()
        // then
        assertEquals(listOf("firstTask", "secondTask"), result)
    }
}