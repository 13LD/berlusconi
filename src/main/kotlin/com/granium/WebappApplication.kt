package com.granium

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class WebappApplication

fun main(args: Array<String>) {
    SpringApplication.run(WebappApplication::class.java, *args)
}
