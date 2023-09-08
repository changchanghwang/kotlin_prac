package com.example.todot_list.todo.infrastructure

import com.example.todot_list.todo.domain.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository :JpaRepository<Todo, String>{
    fun findByTitle(title:String) : Todo?
}