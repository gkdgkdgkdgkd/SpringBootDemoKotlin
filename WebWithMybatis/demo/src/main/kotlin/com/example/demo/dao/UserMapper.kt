package com.example.demo.dao

import com.example.demo.entity.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component

@Mapper
@Component
interface UserMapper
{
    @Select("select * from user where id = #{id}")
    fun selectById(@Param("id") id:String): User?

    @Select("select * from user")
    fun selectAll():List<User>

    fun insert(@Param("user") user:User):Int

    fun deleteById(@Param("id") id:String):Int

    fun update(@Param("user") user: User):Int
}