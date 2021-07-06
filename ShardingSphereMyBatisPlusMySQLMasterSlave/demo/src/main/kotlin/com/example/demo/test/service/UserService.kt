package com.example.demo.test.service

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.test.entity.User
import com.example.demo.test.mapper.UserMapper
import org.springframework.stereotype.Service

@Service
class UserService : ServiceImpl<UserMapper, User>(),IService<User>