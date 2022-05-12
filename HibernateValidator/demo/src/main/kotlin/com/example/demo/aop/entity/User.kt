package com.example.demo.aop.entity

import com.example.demo.aop.annotation.MyEmail
import com.example.demo.aop.annotation.MyPhone

class User {
    @MyPhone(order = 1)
    lateinit var phone:String
    @MyEmail(order = 2)
    lateinit var email:String
}