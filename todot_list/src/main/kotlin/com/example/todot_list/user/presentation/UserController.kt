package com.example.todot_list.user.presentation

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.todot_list.user.application.UserService
import com.example.todot_list.user.dto.*

@RestController
@RequestMapping("/users")
class UserController(private val userService:UserService) {
    @PostMapping("/signup")
    fun signup(@RequestBody userSignupDto:UserSignupDto){
        userService.signup(userSignupDto)
    }

    @PostMapping("/signin")
    fun signin(@RequestBody userSigninDto:UserSigninDto){

    }
}