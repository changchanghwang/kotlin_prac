package com.example.toby.dao

import com.example.toby.domain.User

class UserDao(private val connectionMaker: ConnectionMaker) {
    fun add(user:User): Unit {
       val c = connectionMaker.makeConnection()
        val ps = c.prepareStatement("INSERT INTO users(id,name,password) VALUES(?,?,?)")
        ps.setString(1,user.getId())
        ps.setString(2,user.getName())
        ps.setString(3,user.getPassword())

        ps.executeUpdate()
        ps.close()
        c.close()
    }

    fun get(id:String):User{
        val c = connectionMaker.makeConnection()
        val ps = c.prepareStatement("SELECT * FROM users WHERE id = ?")
        ps.setString(1,id)

        val rs = ps.executeQuery()
        rs.next()
        val user = User()
        user.setId(rs.getString("id"))
        user.setName(rs.getString("name"))
        user.setPassword(rs.getString("password"))

        rs.close()
        ps.close()
        c.close()

        return user
    }
}