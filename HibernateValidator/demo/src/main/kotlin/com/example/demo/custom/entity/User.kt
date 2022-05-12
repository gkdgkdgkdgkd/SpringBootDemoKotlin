package com.example.demo.custom.entity

import com.example.demo.custom.annotation.MyPhone

class User {
    @MyPhone
    lateinit var phone: String
    lateinit var email: String
}