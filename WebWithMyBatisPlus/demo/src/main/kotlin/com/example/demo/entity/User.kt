package com.example.demo.entity

class User(var id:String,var username:String,var password:String){
    override fun toString() = "id:$id\nusername:$username\npassword:$password\n"
}