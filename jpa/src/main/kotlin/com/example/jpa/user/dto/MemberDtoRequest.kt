package com.example.jpa.user.dto

import com.example.jpa.common.annotation.ValidateEnum
import com.example.jpa.common.status.Gender
import com.example.jpa.user.entity.Member
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class MemberDtoRequest(
    val id: Long?,

    @field:NotBlank
    @field:Email
    @JsonProperty("email")
    private val _email: String?,

    @field:NotBlank
    @Pattern(
        regexp = "^.*(?=^.{8,}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#\$%^&+=]).*$",
        message = "validation error"
    )
    @JsonProperty("password")
    private val _password: String?,

    @field:NotBlank
    @JsonProperty("name")
    private val _name: String?,

    @field:NotBlank
    @field:ValidateEnum(enumClass = Gender::class, message = "validation error")
    @JsonProperty("gender")
    private val _gender: String?,
) {
    val email: String
        get() = _email!!
    val password: String
        get() = _password!!
    val name: String
        get() = _name!!
    val gender: Gender
        get() = Gender.valueOf(_gender!!)

    fun toEntity(): Member = Member(id, email, password, name, gender)
}

data class LoginDto(
    @field:NotBlank
    @JsonProperty("email")
    private val _email: String,

    @field:NotBlank
    @JsonProperty("password")
    private val _password: String
) {
    val email: String
        get() = _email
    val password: String
        get() = _password
}