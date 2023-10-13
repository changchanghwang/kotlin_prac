package com.example.todot_list.util.token

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.filter.GenericFilterBean

class AuthenticationFilter(private val jwtProvider:JwtProvider):GenericFilterBean() {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val token = this.resolveToken(request as HttpServletRequest)

    }

    private fun resolveToken(request: HttpServletRequest):String?{
        val bearerToken = request.getHeader("Authorization")
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7)
        }
        return null
    }
}