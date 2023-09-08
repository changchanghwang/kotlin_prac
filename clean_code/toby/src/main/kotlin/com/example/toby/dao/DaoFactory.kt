package com.example.toby.dao

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DaoFactory {
    @Bean
    fun userDao():UserDao{
        return UserDao(dataSource())
    }
    @Bean
    fun dataSource():Datasource{
        return DDatasource()
    }
}