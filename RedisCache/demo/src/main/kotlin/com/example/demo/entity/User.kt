package com.example.demo.entity

import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
data class User(var id: Long? = 0, var name: String = "")
//open class User(var id: Long? = 0, var name: String = "")