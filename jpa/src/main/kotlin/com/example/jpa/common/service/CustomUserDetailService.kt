package com.example.jpa.common.service

import com.example.jpa.user.entity.Member
import com.example.jpa.user.repository.MemberRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails =
        memberRepository.findByEmail(username)
            ?.let { createUserDetails(it) }
            ?: throw UsernameNotFoundException(" .")

    private fun createUserDetails(member: Member): UserDetails =
        User(
            member.email,
            passwordEncoder.encode(member.password),
            member.memberRoles!!.map { SimpleGrantedAuthority("ROLE_${it.role}") }
        )
}