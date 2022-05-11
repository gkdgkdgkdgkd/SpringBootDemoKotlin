package com.example.demo.service

import com.example.demo.dao.UserMapper
import com.example.demo.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MyBatisPlusMapper {
    @Autowired
    private lateinit var mapper: UserMapper

    fun save(user: User) = if (mapper.selectById(user.id) != null) mapper.updateById(user) == 1
    else mapper.insert(user) == 1

    fun delete(id: Long) = mapper.deleteById(id) == 1

    fun select(id: Long): User? = mapper.selectById(id)

    fun selectAll(): List<User>? = mapper.selectList(null)
}