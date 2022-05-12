package com.example.demo.base.entity

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class User {
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱非法")
    lateinit var email: String

    @NotBlank(message = "电话不能为空")
    lateinit var phone: String
}