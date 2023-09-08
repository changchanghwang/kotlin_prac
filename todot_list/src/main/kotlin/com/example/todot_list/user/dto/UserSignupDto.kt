package com.example.todot_list.user.dto

data class UserSignupDto(
    val email: String,
    val password: String,
    val passwordConfirm: String,
    val name: String
)
