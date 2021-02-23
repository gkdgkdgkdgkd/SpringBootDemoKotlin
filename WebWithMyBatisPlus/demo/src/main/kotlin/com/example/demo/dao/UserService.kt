package com.example.demo.dao

import com.baomidou.mybatisplus.extension.service.IService
import com.example.demo.entity.User
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Component
interface UserService:IService<User>