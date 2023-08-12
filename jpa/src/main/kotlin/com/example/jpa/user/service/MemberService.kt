package com.example.jpa.user.service

import com.example.jpa.common.exception.InvalidInputException
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
            throw InvalidInputException("email", "이미 존재하는 이메일입니다.")
        }
        val newMember = memberDtoRequest.toEntity()
        memberRepository.save(newMember)
        return "회원가입 완료"
    }
}