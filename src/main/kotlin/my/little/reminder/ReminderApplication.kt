package my.little.reminder

import io.micronaut.runtime.Micronaut

fun main(args: Array<String>) {
    Micronaut.build()
        .args(*args)
        .packages("my.little.reminder.tasks")
        .start()
}