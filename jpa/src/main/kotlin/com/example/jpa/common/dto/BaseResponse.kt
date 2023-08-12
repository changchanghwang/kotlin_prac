package com.example.jpa.common.dto

import com.example.jpa.common.status.ResultCode

data class BaseResponse<T>(
    val result: String = ResultCode.SUCCESS.name,
    val data: T? = null,
    val message: String = ResultCode.SUCCESS.message
)