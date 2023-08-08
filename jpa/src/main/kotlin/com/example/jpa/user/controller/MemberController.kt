package com.example.jpa.user.controller

import com.example.jpa.user.dto.MemberDtoRequest
import com.example.jpa.user.service.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/member")
@RestController
class MemberController(private val memberService: MemberService) {
    @PostMapping("/signup")
    fun signup(@RequestBody memberDtoRequest: MemberDtoRequest): String {
        return memberService.signup(memberDtoRequest)
    }
}