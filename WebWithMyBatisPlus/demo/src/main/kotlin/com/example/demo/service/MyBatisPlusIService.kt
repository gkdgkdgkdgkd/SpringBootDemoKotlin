package com.example.demo.service

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.dao.UserMapper
import com.example.demo.dao.UserService
import com.example.demo.entity.User
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class MyBatisPlusIService : ServiceImpl<UserMapper, User>(), UserService {
    override fun save(user: User) = saveOrUpdate(user)

    fun delete(id: String) = removeById(id)

    fun select(id: String): User? = getById(id)

    fun selectAll(): List<User> = list()
}
