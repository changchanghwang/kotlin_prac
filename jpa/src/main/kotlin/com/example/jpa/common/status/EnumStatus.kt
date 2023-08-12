package com.example.jpa.common.status

enum class Gender(val desc: String) {
    MAN("남"),
    WOMAN("여")
}

enum class ResultCode(val message: String) {
    SUCCESS("성공"),
    ERROR("에러가 발생했습니다.")
}

enum class Role {
    MEMBER
}