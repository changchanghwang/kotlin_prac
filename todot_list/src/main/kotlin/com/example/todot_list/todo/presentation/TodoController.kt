package com.example.todot_list.todo.presentation

import com.example.todot_list.todo.application.TodoService
import com.example.todot_list.todo.domain.Todo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todos")
class TodoController(private val todoService:TodoService) {
    @GetMapping()
    fun list():List<Todo>{
        return todoService.list()
    }
}