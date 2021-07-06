package com.example.demo.user

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId

data class User(
    @TableId(type = IdType.ASSIGN_ID)
    var id: Long?,
    var name: String,
    var age: Int,
    var email: String,
) {
    constructor(name: String, age: Int, email: String) : this(null,name,age,email)
}