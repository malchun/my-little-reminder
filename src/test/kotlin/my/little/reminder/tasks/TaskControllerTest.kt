package my.little.reminder.tasks

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class TaskControllerTest {
    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun `GET task returns 200 and all tasks`() {
        // given
        val request: HttpRequest<Any> = HttpRequest.GET("/task/")
        // when
        val response = client.toBlocking().exchange(request, String::class.java)
        // then
        assertEquals(HttpStatus.OK , response.status())
        assertEquals("[firstTask, secondTask]", response.body())
    }
}