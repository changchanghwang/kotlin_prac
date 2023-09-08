package com.example.todot_list.todo.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table()
class Todo(
    @Id
    var id: String,

    @Column(nullable = false, length = 255)
    var title: String,

    @Column(nullable = false, length = 10)
    var writerId: String,
)
