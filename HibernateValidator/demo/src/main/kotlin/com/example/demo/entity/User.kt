package com.example.demo.entity

import com.example.demo.annotation.Phone
import javax.validation.GroupSequence
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class User{
    @NotBlank(message = "邮箱不能为空",groups = [GroupA::class])
    @Email(message = "邮箱非法",groups = [GroupA::class])
//    @NotBlank(message = "邮箱不能为空",groups = [First::class])
//    @Email(message = "邮箱非法",groups = [Second::class])
//    @MyEmail(order = 2)
    lateinit var email:String

    @NotBlank(message = "电话不能为空",groups = [GroupA::class,GroupB::class])
//    @NotBlank(message = "电话不能为空",groups = [Third::class])
//    @Phone
//    @MyPhone(order = 1)
    lateinit var phone:String

    interface GroupA
    interface GroupB
//    interface First
//    interface Second
//    interface Third
//    @GroupSequence(First::class,Second::class,Third::class)
//    interface Group
}