package com.example.jpa.common

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController {
    @GetMapping("/ping")
    fun pingpong(): String {
        return "pong"
    }
}
