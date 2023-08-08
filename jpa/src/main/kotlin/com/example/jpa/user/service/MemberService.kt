package com.example.jpa.user.service

import com.example.jpa.user.dto.MemberDtoRequest
import com.example.jpa.user.entity.Member
import com.example.jpa.user.repository.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService(private val memberRepository: MemberRepository) {

    /**
     * 회원가입
     */
    fun signup(memberDtoRequest: MemberDtoRequest): String {
        val member: Member? = memberRepository.findByEmail(memberDtoRequest.email)
        if (member !== null) {
            return "이미 가입된 회원입니다."
        }
        val newMember = Member(
            null,
            memberDtoRequest.email,
            memberDtoRequest.password,
            memberDtoRequest.name,
            memberDtoRequest.gender,
        )
        memberRepository.save(newMember)
        return "회원가입 완료"
    }
}