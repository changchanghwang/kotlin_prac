package com.example.jpa.user.dto

import com.example.jpa.common.status.Gender

data class MemberDtoRequest(
    val email: String,
    val password: String,
    val name: String,
    val gender: Gender,
)