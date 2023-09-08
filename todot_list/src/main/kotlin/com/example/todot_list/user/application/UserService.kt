package com.example.todot_list.user.application

import com.example.todot_list.user.domain.User
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import com.example.todot_list.user.infrastructrue.UserRepository
import com.example.todot_list.user.dto.UserSignupDto
import java.util.UUID

@Service
@Transactional
class UserService(private val userRepository:UserRepository) {
    fun signup(userSignupDto:UserSignupDto){
        if(userSignupDto.password != userSignupDto.passwordConfirm){
            throw Exception("비밀번호가 일치하지 않습니다.")
        }

        val user = User(UUID.randomUUID(), userSignupDto.email, userSignupDto.password, userSignupDto.name)
        userRepository.save(user)
    }
}