package com.example.toby.dao

import java.sql.Connection
import java.sql.DriverManager


interface ConnectionMaker {
     fun makeConnection(): Connection
}

class DConnectionMaker: ConnectionMaker {
    override fun makeConnection():Connection {
        Class.forName("com.mysql.jdbc.Driver")
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/study?serverTimezone=UTC",
            "root",
            "1234"
        )
    }
}