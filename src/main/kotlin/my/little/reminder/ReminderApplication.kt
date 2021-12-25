package my.little.reminder

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@OpenAPIDefinition(
    info = Info(
        title = "Simple reminder application",
        version = "0.0",
        description = "My API",
        license = License(name = "Apache 2.0", url = "https://foo.bar")
    )
)
object ReminderApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
            .args(*args)
            .packages("my.little.reminder.tasks")
            .start()
    }
}