package com.example.jpa.user.controller

import com.example.jpa.common.authority.Tokeninfo
import com.example.jpa.common.dto.BaseResponse
import com.example.jpa.user.dto.LoginDto
import com.example.jpa.user.dto.MemberDtoRequest
import com.example.jpa.user.service.MemberService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/member")
@RestController
class MemberController(private val memberService: MemberService) {
    @PostMapping("/signup")
    fun signup(@RequestBody @Valid memberDtoRequest: MemberDtoRequest): BaseResponse<Unit> {
        val resultMessage: String = memberService.signup(memberDtoRequest)
        return BaseResponse(message = resultMessage)
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid loginDto: LoginDto): BaseResponse<Tokeninfo> {
        val token = memberService.login(loginDto)
        return BaseResponse(data = token)
    }
}