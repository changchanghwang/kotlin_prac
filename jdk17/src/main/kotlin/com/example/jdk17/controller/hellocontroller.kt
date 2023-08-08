package com.example.jdk17.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class hellocontroller {
    @GetMapping("/hello")
    @ResponseBody
    fun hello(@RequestParam("name", required = false) name: String? ): String {
        return "Hello ${name ?: "World"}"
    }
}