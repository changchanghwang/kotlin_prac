package com.example.toby.dao

import java.sql.Connection
import java.sql.DriverManager


interface Datasource {
     fun makeConnection(): Connection
}

class DDatasource: Datasource {
    private var count = 0
    override fun makeConnection():Connection {
        Class.forName("com.mysql.jdbc.Driver")
        this.count++
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/study?serverTimezone=UTC",
            "root",
            "1234"
        )
    }

    fun getCount():Int {
        return this.count
    }
}