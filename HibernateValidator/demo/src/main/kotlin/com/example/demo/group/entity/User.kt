package com.example.demo.group.entity

import com.example.demo.group.groups.sequence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class User {
    @NotBlank(message = "登录时电话不能为空", groups = [SignInFirstCheck::class])
    @NotBlank(message = "注册时电话不能为空", groups = [SignUpFirstCheck::class])
    lateinit var phone: String

    @NotBlank(message = "登录时邮箱不能为空", groups = [SignInSecondCheck::class])
    @NotBlank(message = "注册时邮箱不能为空", groups = [SignUpSecondCheck::class])
    @Email(message = "登录邮箱非法", groups = [SignInThirdCheck::class])
    @Email(message = "注册邮箱非法", groups = [SignUpThirdCheck::class])
    lateinit var email: String
}