package com.example.jpa.user.entity

import com.example.jpa.common.status.Gender
import com.example.jpa.common.status.Role
import jakarta.persistence.*

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(name = "uk_user_email", columnNames = ["email"])]
)
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, updatable = false, length = 30, unique = true)
    var email: String,

    @Column(nullable = false, length = 10)
    var password: String,

    @Column(nullable = false, length = 20)
    var name: String,

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    var gender: Gender,
) {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    val memberRoles: List<MemberRole>? = null
}

@Entity
class MemberRole(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    val role: Role,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "fk_member_role_member_id"))
    val member: Member
)