package com.example.todot_list.user.domain

import jakarta.persistence.*
import java.util.*

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(name = "uk_user_email", columnNames = ["email"])]
)
class User (
    @Id
    var id: UUID,

    @Column(nullable = false, updatable = false, length = 30, unique = true)
    var email : String,

    @Column(nullable = false, length = 255)
    var password: String,

    @Column(nullable = false, length = 50)
    var name: String,
)