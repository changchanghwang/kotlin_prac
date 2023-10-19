package com.example.todot_list.util.token

import io.jsonwebtoken.*
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtProvider(private val userDetailsService: UserDetailsService) {
    val secretKey = "이게 시크릿 키라는 거야."
    private val accessTokenValidTime = 1000 * 60 * 30L
    private val refreshTokenValidTime = 1000 * 60 * 60 * 24 * 7L

    private val key = Keys.hmacShaKeyFor(secretKey.toByteArray())

    fun createAccessToken(userId:UUID):String{
        val now = Date()
        val expiration = Date(now.time + accessTokenValidTime)
        val accessToken = Jwts.builder().setSubject(userId.toString()).claim("userId",userId).setIssuedAt(now).setExpiration(expiration).signWith(key,SignatureAlgorithm.HS256).compact()
        return accessToken
    }

    fun createRefreshToken():String{
        val now = Date()
        val expiration = Date(now.time + refreshTokenValidTime)
        val refreshToken = Jwts.builder().setSubject("refresh").setIssuedAt(now).setExpiration(expiration).signWith(key,SignatureAlgorithm.HS256).compact()
        return refreshToken
    }

    fun getAuthentication(token:String): Authentication {
        val userDetails = userDetailsService.loadUserByUsername(token)
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    fun getUserId(accessToken:String):UUID{
        val claims = this.getClaims(accessToken)
        return UUID.fromString(claims["userId"].toString())
    }

    fun getClaims(token:String):Claims{
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).body
    }
}