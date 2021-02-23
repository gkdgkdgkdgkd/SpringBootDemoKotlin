package com.example.demo.dao

import com.baomidou.mybatisplus.extension.service.IService
import com.example.demo.entity.User
import org.springframework.stereotype.Component

@Component
interface UserService:IService<User>