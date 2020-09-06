package com.example.demo.service

import com.example.demo.dao.UserMapper
import com.example.demo.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.CrossOrigin

@Service
class Service
{
    @Autowired
    lateinit var mapper:UserMapper

    fun save(user: User):Boolean
    {
        val currentUser = select(user.id)
        if(currentUser!=null)
            mapper.update(user)
        else
            mapper.insert(user)
        return true
    }

    fun select(id:String)=mapper.selectById(id)

    fun selectAll()=mapper.selectAll()

    fun delete(id:String)=mapper.deleteById(id) == 1
}