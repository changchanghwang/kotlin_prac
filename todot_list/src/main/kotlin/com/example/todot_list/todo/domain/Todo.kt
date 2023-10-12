package com.example.todot_list.todo.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name="todo")
class Todo(
    @Id
    var id: String,

    @Column(nullable = false, length = 255)
    var title: String,

    @Column(nullable = false, length = 10, name="writerId")
    var writerId: UUID,
)
