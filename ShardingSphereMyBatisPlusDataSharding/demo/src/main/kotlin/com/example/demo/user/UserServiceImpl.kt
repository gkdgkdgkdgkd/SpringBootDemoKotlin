package com.example.demo.user

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service

@Service
class UserServiceImpl:ServiceImpl<UserMapper,User>(),IService<User>