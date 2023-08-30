package com.example.toby

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TobyApplication

fun main(args: Array<String>) {
	runApplication<TobyApplication>(*args)
}
