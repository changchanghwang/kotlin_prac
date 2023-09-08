package com.example.todot_list.user.infrastructrue

import com.example.todot_list.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {
}