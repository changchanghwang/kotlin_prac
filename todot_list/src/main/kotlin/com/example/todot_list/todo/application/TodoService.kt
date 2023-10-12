package com.example.todot_list.todo.application

import com.example.todot_list.todo.domain.Todo
import com.example.todot_list.todo.infrastructure.TodoRepository
import org.springframework.stereotype.Service

@Service()
class TodoService(private val todoRepository: TodoRepository) {

    fun list():List<Todo>{
        return this.todoRepository.findAll()
    }
}