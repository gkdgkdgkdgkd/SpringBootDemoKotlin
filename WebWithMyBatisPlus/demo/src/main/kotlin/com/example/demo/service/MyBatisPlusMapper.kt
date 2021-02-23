package com.example.demo.service

import com.example.demo.dao.UserMapper
import com.example.demo.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class MyBatisPlusMapper
{
    @Autowired
    private lateinit var mapper: UserMapper

    fun save(user: User):Boolean
    {
        if(mapper.selectById(user.id) != null)
            return mapper.updateById(user) == 1
        return mapper.insert(user) == 1
    }

    fun delete(id:String) = (mapper.deleteById(id) == 1)

    fun select(id:String): User? = mapper.selectById(id)

    fun selectAll():List<User> = mapper.selectList(null)
}