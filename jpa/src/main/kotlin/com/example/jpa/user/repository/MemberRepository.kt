package com.example.jpa.user.repository

import com.example.jpa.user.entity.Member
import com.example.jpa.user.entity.MemberRole
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByEmail(email: String): Member?
}

interface MemberRoleRepository : JpaRepository<MemberRole, Long>