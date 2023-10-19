package com.example.todot_list.util.token

import io.jsonwebtoken.Jwts
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import java.util.*

class AuthenticationFilter(private val jwtProvider:JwtProvider):GenericFilterBean() {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val token = this.resolveToken(request as HttpServletRequest)
        try {
            val claims = Jwts.parser().setSigningKey(this.jwtProvider.secretKey).parseClaimsJws(token)
            if(!claims.body.expiration.before(Date())){
                val authentication = jwtProvider.getAuthentication(token!!)
                SecurityContextHolder.getContext().authentication = authentication
            }
        } catch (e: Exception) {
            false
        }
    }

    private fun resolveToken(request: HttpServletRequest):String?{
        val bearerToken = request.getHeader("Authorization")
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7)
        }
        return null
    }
}