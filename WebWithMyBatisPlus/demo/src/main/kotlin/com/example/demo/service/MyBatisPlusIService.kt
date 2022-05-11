package com.example.demo.service

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.dao.UserMapper
import com.example.demo.dao.UserService
import com.example.demo.entity.User
import org.springframework.stereotype.Service

@Service
class MyBatisPlusIService:ServiceImpl<UserMapper,User>(),UserService {
    override fun save(user:User) = if(getById(user.id) != null) updateById(user)
    else super<ServiceImpl>.save(user)

    fun delete(id:Long) = removeById(id)

    fun select(id:Long): User? = getById(id)

    fun selectAll(): List<User>? = list()
}