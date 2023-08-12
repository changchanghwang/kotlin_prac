package com.example.jpa.user.service

import com.example.jpa.common.authority.JwtTokenProvider
import com.example.jpa.common.authority.Tokeninfo
import com.example.jpa.common.exception.InvalidInputException
import com.example.jpa.common.status.Role
import com.example.jpa.user.dto.LoginDto
import com.example.jpa.user.dto.MemberDtoRequest
import com.example.jpa.user.entity.Member
import com.example.jpa.user.entity.MemberRole
import com.example.jpa.user.repository.MemberRepository
import com.example.jpa.user.repository.MemberRoleRepository
import jakarta.transaction.Transactional
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val memberRoleRepository: MemberRoleRepository,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val jwtTokenProvider: JwtTokenProvider
) {

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

        val memberRole: MemberRole = MemberRole(role = Role.MEMBER, member = newMember)
        memberRoleRepository.save(memberRole)
        return "회원가입 완료"
    }

    fun login(loginDto: LoginDto): Tokeninfo {
        val authenticationToken = UsernamePasswordAuthenticationToken(loginDto.email, loginDto.password)
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)

        return jwtTokenProvider.createToken(authentication)
    }
}