package com.example.jpa.common.exception

import com.example.jpa.common.dto.BaseResponse
import com.example.jpa.common.status.ResultCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CustomExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun methodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<BaseResponse<Map<String, String>>> {
        val errors = mutableMapOf<String, String>()
        e.bindingResult.fieldErrors.forEach { error ->
            val fieldName = error.field
            val errorMessage = error.defaultMessage
            errors[fieldName] = errorMessage ?: "Not Exception Message"
        }
        return ResponseEntity(
            BaseResponse(ResultCode.ERROR.name, errors, ResultCode.ERROR.message),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(InvalidInputException::class)
    protected fun invalidInputException(ex: InvalidInputException): ResponseEntity<BaseResponse<Map<String, String>>> {
        val errors = mapOf(ex.fieldName to (ex.message ?: "Not Exception Message"))
        return ResponseEntity(
            BaseResponse(
                ResultCode.ERROR.name,
                errors,
                ResultCode.ERROR.message
            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(Exception::class)
    protected fun defaultException(ex: Exception): ResponseEntity<BaseResponse<Map<String, String>>> {
        val errors = mapOf("unExpected Error" to (ex.message ?: "Not Exception Message"))
        return ResponseEntity(
            BaseResponse(
                ResultCode.ERROR.name,
                errors,
                ResultCode.ERROR.message
            ), HttpStatus.BAD_REQUEST
        )
    }
}